package com.db;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class LogNote extends JFrame{

    private JPanel logNotePanel;
    private JTextArea noteTextArea;
    private JButton logNoteButton;
    private JTable resultTable;
    private JButton goBackButton;

    private String[] col_name = {"Staff Member", "Note", "Time"};

    public LogNote() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("Atlanta Zoo: Staff Log Note");
        setSize(500,500);

        String[][] data = {{"name","note","time"}}; // row data

        DefaultTableModel df = new DefaultTableModel(data, col_name);
        resultTable.setModel(df);
        resultTable.setCellSelectionEnabled(true);

        add(logNotePanel);
        pack();

        // go back button
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                SearchAnimals sf = new SearchAnimals();
                sf.setVisible(true);

                setVisible(false);  //hide and close current window

                dispose();
            }
        }); // end go back button action




    } // end constructor

} // end class
