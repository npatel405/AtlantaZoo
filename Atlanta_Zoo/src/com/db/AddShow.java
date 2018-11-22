package com.db;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddShow extends JFrame {
    private JTextField Name;
    private JComboBox Staff;
    private JTextField Date;
    private JTextField Time;
    private JButton addShowButton;
    private JComboBox Exhibit;
    private JPanel AddShowPanel;

    public AddShow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(AddShowPanel);
        setSize(500, 500);
        setTitle("Atlanta Zoo: Add Show");

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:myDriver:DatabaseName",
                    "123",
                    "456");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT DISTINCT Name FROM Exhibit");
            rs.last();
            int rowCount = rs.getRow();
            rs.beforeFirst();
            String[] exhibitList = new String[rowCount];
            int i = 0;
            while(rs.next()){
                exhibitList[i++] = rs.getString("Name");
            }
            Exhibit = new JComboBox(exhibitList);

            rs = statement.executeQuery("SELECT DISTINCT Name FROM Staff");
            rs.last();
            rowCount = rs.getRow();
            rs.beforeFirst();
            String[] staffList = new String[rowCount];
            int j = 0;
            while(rs.next()){
                staffList[i++] = rs.getString("Name");
            }
            Staff = new JComboBox(staffList);

        } catch (Exception el){
            System.out.println(el);
        }

        addShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String showName = Name.getText();
                String exhibit = (String) Exhibit.getSelectedItem();
                String staff = (String) Staff.getSelectedItem();
                String date = Date.getText();
                String time = Time.getText();
                try{
                    Connection connection = DriverManager.getConnection(
                            "jdbc:myDriver:DatabaseName",
                            "123",
                            "456");
                    Statement statement = connection.createStatement();
                    int res = statement.executeUpdate("INSERT INTO User VALUES('"+showName + "','"+ exhibit + "','" + staff + "','" + date + time + "')");
                    if(res == 1) {
                        // Go back to Admin Functionality
                    }
                    else{
                        JOptionPane.showMessageDialog(AddShowPanel, "Failed to add show. Please make sure the show's name, date and time are correct");
                    }
                }catch (Exception el){
                    System.out.println(el);
                }
            }
        });
    }
}
