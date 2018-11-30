package com.db;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// accessible from visitor functionality page
public class SearchForAnimals extends JFrame {

    private JPanel searchForAnimalsPanel;

    private JButton goBackButton;
    private JTable resultTable;
    private JButton searchButton;
    private JTextField nameTextField;
    private JTextField speciesTextField;
    private JComboBox exhibitNameDropDown;
    private JComboBox animalTypeDropDown;
    private JComboBox ageMinDropDown;
    private JComboBox ageMaxDropDown;

    private String[] col_name = {"Name", "Species", "Exhibit", "Age", "Type"};

    public SearchForAnimals() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String[][] data = {{"name","species","exhibit","age","type"}}; // row data
        DefaultTableModel df = new DefaultTableModel(data, col_name);
        resultTable.setModel(df);
        resultTable.setCellSelectionEnabled(true);


        add(searchForAnimalsPanel);
        setTitle("Atlanta Zoo: Visitor Search for Animals");
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


    } // end SearchForAnimals constructor

} // end SearchForAnimals class
