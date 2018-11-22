package com.db;

import javax.swing.*;

public class VisitorFunctionality extends JFrame{
    private JButton searchExhibitsButton;
    private JButton viewExhibitHistoryButton;
    private JButton searchShowsButton;
    private JButton viewShowHistoryButton;
    private JButton searchAnimalsButton;
    private JButton logOutButton;
    private JPanel visitorFunctionalityPanel;

    public VisitorFunctionality(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(visitorFunctionalityPanel);
        setTitle("Atlanta Zoo: Visitor Functionality");
        setSize(500, 500);
    }
}
