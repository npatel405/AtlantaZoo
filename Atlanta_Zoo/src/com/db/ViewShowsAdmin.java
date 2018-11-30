package com.db;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// accessible from Administrator Functionality page
public class ViewShowsAdmin extends JFrame {

    private JPanel viewShowsAdminPanel;
    private JButton goBackButton;
    private JTable resultTable;
    private JButton searchButton;
    private JTextField nameTextField;
    private JTextField dateTextField;
    private JComboBox exhibitDropDown;
    private JButton removeShowButton;

    private String[] col_name = {"Name", "Exhibit","Date"};

    public ViewShowsAdmin() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        String[][] data = {{"name","exhibit","date"}}; // row data
        DefaultTableModel df = new DefaultTableModel(data, col_name);
        resultTable.setModel(df);
        resultTable.setCellSelectionEnabled(true);




        add(viewShowsAdminPanel);
        setTitle("Atlanta Zoo: Administrator View Shows");
        setSize(500,500);

        // goBack button
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AdministratorFunctionality af = new AdministratorFunctionality();
                af.setVisible(true);

                setVisible(false);  //hide and close current window
                dispose();
            }
        }); // end button action


    } // end constructor

} // end class
