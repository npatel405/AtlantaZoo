package com.db;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// accessible from visitor functionality page
public class ViewExhibitHistory extends JFrame {

    private JPanel viewExhibitHistoryPanel;
    private JButton goBackButton;
    private JTextField nameTextField;
    private JTextField timeTextField;
    private JButton searchButton;
    private JComboBox minNumVisits_DropDown;
    private JComboBox maxNumVisits_DropDown;
    private JTable resultTable;

    private String[] col_name = {"Name", "Time", "Number of Visits"};

    public ViewExhibitHistory() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String[][] data = {{"name","time","numVisits"}}; // row data
        DefaultTableModel df = new DefaultTableModel(data, col_name);
        resultTable.setModel(df);
        resultTable.setCellSelectionEnabled(true);


        add(viewExhibitHistoryPanel);
        setTitle("Atlanta Zoo: Visitor View Exhibit History");
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


    } // end ViewExhibitHistory constructor

} // end ViewExhibitHistory class
