package com.db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// accessible from Administrator Functionality page
public class ViewShowsAdmin extends JFrame {

    private JPanel viewShowsAdminPanel;
    private JButton goBackButton;

    public ViewShowsAdmin() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
