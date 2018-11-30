package com.db;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// accessible from staff functionality page
public class SearchAnimals extends JFrame {

    private JPanel searchAnimalsPanel;

    private JButton goBackButton;
    private JComboBox exhibitDropDown;
    private JTextField nameTextField;
    private JTextField speciesTextField;
    private JComboBox animalType;
    private JComboBox ageMin;
    private JComboBox ageMax;
    private JTable resultTable;
    private JButton selectAnimalButton;

    private String[] col_name = {"Name", "Species", "Exhibit", "Age", "Type"};


    public SearchAnimals() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("Atlanta Zoo: Staff Animal Search");
        setSize(500,500);

        String[][] data = {{"name","species","exhibit","age", "type"}}; // row data

        DefaultTableModel df = new DefaultTableModel(data, col_name);
        resultTable.setModel(df);
        resultTable.setCellSelectionEnabled(true);

        add(searchAnimalsPanel);
        pack();


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


        // select animal button
        selectAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LogNote ln = new LogNote();
                ln.setVisible(true);

                setVisible(false);  //hide and close current window

                dispose();
            }
        }); // end go back button action




    } // end ViewShows constructor


} // end SearchAnimals class
