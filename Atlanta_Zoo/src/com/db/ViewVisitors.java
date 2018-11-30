package com.db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// accessible from Administrator Functionality page
public class ViewVisitors extends JFrame {

    private JPanel viewVisitorsPanel;
    private JButton goBackButton;

    public ViewVisitors() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
