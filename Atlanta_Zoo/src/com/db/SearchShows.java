package com.db;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// accessible from visitor functionality page
public class SearchShows extends JFrame {

    private JPanel searchShowsPanel;
    private JButton goBackButton;
    private JTextField showName_textfield;
    private JTextField dateTextField;
    private JComboBox exhibitNameDropDown;
    private JButton searchButton;
    private JButton logVisitButton;
    private JTable resultTable;

    private String[] col_name = {"Name", "Exhibit", "Date"};

    public SearchShows() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        String[][] data = {{"name","exhibit","date"}}; // row data
        DefaultTableModel df = new DefaultTableModel(data, col_name);
        resultTable.setModel(df);
        resultTable.setCellSelectionEnabled(true);


        add(searchShowsPanel);
        setTitle("Atlanta Zoo: Visitor Search Shows");
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

    } // end searchShows constructor

} // end SearchShows class
