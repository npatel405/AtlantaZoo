package com.db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// accessible from Administrator Functionality page
public class ViewAnimals extends JFrame {
    private JPanel viewAnimalsPanel;
    private JButton goBackButton;
    private JComboBox exhibitDropDown;
    private JButton searchButton;
    private JTextField nameTextField;
    private JTextField speciesTextField;
    private JComboBox animalTypeDropDown;
    private JComboBox ageMinDropDown;
    private JComboBox ageMaxDropDown;
    private JTable resultTable;
    private JButton removeAnimalButton;


    public ViewAnimals() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(viewAnimalsPanel);
        setTitle("Atlanta Zoo: Administrator View Animals");
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
