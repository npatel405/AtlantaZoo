package com.db;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// accessible from visitor functionality page
public class ViewShowHistory extends JFrame {

    private JPanel viewShowHistoryPanel;
    private JButton goBackButton;
    private JTextField nameTextField;
    private JTextField timeTextField;
    private JComboBox exhibitNameDropDown;
    private JTable resultTable;
    private JButton searchButton;

    private String[] col_name = {"Name","Time", "Exhibit"};

    public ViewShowHistory(){

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String[][] data = {{"name","time","exhibit"}}; // row data
        DefaultTableModel df = new DefaultTableModel(data, col_name);
        resultTable.setModel(df);
        resultTable.setCellSelectionEnabled(true);


        add(viewShowHistoryPanel);
        setTitle("Atlanta Zoo: Visitor View Show History");
        setSize(500,500);



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


    } // end ViewShowHistory constructor


} // end ViewShowHistory class
