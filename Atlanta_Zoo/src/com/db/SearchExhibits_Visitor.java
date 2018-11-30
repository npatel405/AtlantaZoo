package com.db;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchExhibits_Visitor extends JFrame {
    private JComboBox water_feat;
    private JSpinner min_size;
    private JSpinner max_size;
    private JTextField exhibit_name;
    private JSpinner min_num;
    private JSpinner max_num;
    private JButton searchButton;
    private JPanel searchexhibitsvPanel;
    private JTable result;          //show the search result
    private JButton goBackButton;
    private String[] col_name = {"Name", "Size", "NumAnimals", "Water"};

    public SearchExhibits_Visitor(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        String[][] data = {{"1","2","3","4"}}; //this is the row
        DefaultTableModel df = new DefaultTableModel(data, col_name);
        result.setModel(df);
        result.setCellSelectionEnabled(true);
        //searchexhibitsvPanel.setBackground(Color.ORANGE);
        setTitle("Atlanta Zoo: Visitor Exhibit Search");
        setSize(500,500);
        add(searchexhibitsvPanel);
        pack();

        //click the search result, navigate to exhibit detail
        ListSelectionModel select = result.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String Exhibits = (String) result.getValueAt(result.getSelectedRows()[0],0);        //column 0 is Name
                //goes to Exhibits detail page
            }
        });

        // go back button
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VisitorFunctionality vf = new VisitorFunctionality();
                vf.setVisible(true);

                setVisible(false);  //hide and close current window
                dispose();
            }
        }); // end go back button action

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Exhibit_name = exhibit_name.getText();               //maybe empty
                String Water_feat = (String) water_feat.getSelectedItem();  //N/A, Yes, No
                int Max_size;
                int Min_size;
                int Max_num;
                int Min_num;

                //ensure manually typed values with the editor are propagated to the model
                try {
                    max_num.commitEdit();
                    min_num.commitEdit();
                    max_size.commitEdit();
                    min_size.commitEdit();
                }catch (Exception e3){
                    System.err.println(e3);
                }

                Max_size = (Integer) max_size.getValue();
                Min_size = (Integer) min_size.getValue();
                Max_num = (Integer) max_num.getValue();
                Min_num = (Integer) min_num.getValue();

                //check if min and max pairs are valid
                if(Min_size <= Max_size && Min_num <= Max_num){
                    String sql = "Select Name, Size, WaterFeature, Animal_Number From Exhibit Join number_Animal On Name = Animal_Exhibit Where Size Between " + Min_size + "and " + Max_size + "number_Animal Between " + Min_num + "and " + Max_num;
                    if(Exhibit_name != null){
                        sql += " and Name = " + Exhibit_name;
                    }
                    if(!Water_feat.equals("N/A")){
                        sql += " and WaterFeature = " + Water_feat;
                    }

                    try {
                        Connection con = DriverManager.getConnection(
                                "https://academic-mysql.cc.gatech.edu/phpmyadmin",
                                "cs4400_group18",
                                "R7mNv3pS");

                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        //create new DefaultTable Module using ResultSet, and reset JTable
                        DefaultTableModel tableModel = new DefaultTableModel(col_name,0);
                        while(rs.next()){
                            //construct row
                            Object[] row = {rs.getString("Name"),rs.getInt("Size"),rs.getString("WaterFeature"),rs.getInt("Animal_Number")};
                            tableModel.addRow(row);
                        }
                        result.setModel(tableModel);
                        con.close();

                    }catch (Exception e4){
                        System.err.println(e4);
                    }

                }else{
                    JOptionPane.showMessageDialog(searchexhibitsvPanel,
                            "Min cannot be greater than Max!");
                }
            }
        });
    }

}
