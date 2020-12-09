package com.ayushman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Main implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel usernameLabel;
    private static JTextField usernameText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel successLabel;

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameText.getText();
        String password = passwordText.getText();
        System.out.println("Username : " + username + "\nPassword : " + password);

        if (username.equals("bossever") && password.equals("1234")) {
            successLabel.setText("Logged in successfully!");
        }
        else {
            successLabel.setText("Incorrect username/password");
        }
    }

    public static void main(String[] args) {
        frame = new JFrame();
        frame.setSize(275, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Experiments with Swing");

        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        //username label & text field
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 20, 80, 25);
        panel.add(usernameLabel);

        usernameText = new JTextField( 25);
        usernameText.setBounds(100, 20, 165, 25);
        panel.add(usernameText);

        //password label & password text field
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField( 25);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.addActionListener(new Main());
        button.setBounds(90, 90, 95, 30);
        panel.add(button);

        successLabel = new JLabel("");
        successLabel.setBounds(50, 120, 250, 30);
        panel.add(successLabel);

        frame.setVisible(true);

    }

}
