package com.db;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://academic-mysql.cc.gatech.edu/";
        String USER = "cs4400_group18";
        String PASS = "R7mNv3pS";
        JLabel msg = new JLabel();
        JFrame frame = new JFrame();
        Connection con = null;
        try {
          //  Class.forName(DRIVER).newInstance();
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(con.toString());
//            if (!con.isClosed()) {
//                System.out.println("Successfully connected to " +
//                        "MySQL server using TCP/IP...");
//            }
//            msg.setText("That username is already taken. Please try again.");
//            frame.getContentPane().add(BorderLayout.NORTH, msg);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
//            try {
//                if (con != null)
//                    con.close();
//            } catch (SQLException e) {}


            // Three user types:

            // Administrator
            AdministratorFunctionality af = new AdministratorFunctionality();
            af.setVisible(true);

            // Staff
            StaffFunctionality sf = new StaffFunctionality();
            sf.setVisible(true);

            // Visitor
            VisitorFunctionality vf = new VisitorFunctionality();
            vf.setVisible(true);




        }
    }
}
