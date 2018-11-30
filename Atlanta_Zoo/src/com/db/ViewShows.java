package com.db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

// accessible from staff functionality page
public class ViewShows extends JFrame {





    private JPanel viewShowsPanel;
    private JButton goBackButton;

    private JTable showsTable;
    private JScrollPane tableContainer;

    private String[] col_name = {"Name", "Time", "Exhibit"};


    public ViewShows() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //viewShowsPanel.setBackground(Color.lightGray);

        String[][] data = {{"Show_Name","Show_Time","Exhibit_Name"}}; //this is the row

        DefaultTableModel df = new DefaultTableModel(data, col_name);
        showsTable.setModel(df);
        showsTable.setCellSelectionEnabled(true); // should probably change to false
        pack();

        add(viewShowsPanel);
        setTitle("Atlanta Zoo: Staff View Shows");
        setSize(500,500);



        // go back button
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ViewShows vs = new ViewShows();
                //vs.setVisible(true);
                StaffFunctionality sf = new StaffFunctionality();
                sf.setVisible(true);

                setVisible(false);  //hide and close current window

                dispose();
            }
        }); // end go back button action

    } // end ViewShows constructor




} // end ViewShows class
