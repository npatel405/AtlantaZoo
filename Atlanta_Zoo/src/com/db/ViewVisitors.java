package com.db;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// accessible from Administrator Functionality page
public class ViewVisitors extends JFrame {

    private JPanel viewVisitorsPanel;
    private JButton goBackButton;
    private JTable resultTable;
    private JButton deleteVisitorButton;

    private String[] col_name = {"Username", "Email"};

    public ViewVisitors() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String[][] data = {{"username","email"}}; // row data
        DefaultTableModel df = new DefaultTableModel(data, col_name);
        resultTable.setModel(df);
        resultTable.setCellSelectionEnabled(true);


        add(viewVisitorsPanel);
        setTitle("Atlanta Zoo: Administrator View Visitors");
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
