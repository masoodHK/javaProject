package com.auth;
import com.downloader.DownloadManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JFrame{
    private JPanel panel1;
    private JPanel headerLabel;
    private JLabel loginLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;

    private boolean loginConfirmed;

    private DownloadManager mainFrame = new DownloadManager();

    private Connection connection = null;

    public LoginForm() {
        super("File Download Manager - Login");

        this.setSize(450,350);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("org.sqlite.JDBC");
                    connection = DriverManager.getConnection("jdbc:sqlite:main.sqlite");
                    confirmLogin();
                } catch(Exception error) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Error: " + error.toString());
                }
            }
        });
        this.add(panel1);
    }

    private void confirmLogin() {
        if(loginConfirmed) {
            this.dispose();
            mainFrame.showDownloadManager();
        }
    }
}
