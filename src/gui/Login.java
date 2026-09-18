package gui;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    JLabel userLabel, passLabel;
    JTextField userText;
    JPasswordField passText;
    JButton loginBtn, exitBtn;

    public Login() {
        setTitle("Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Student Result Management System");
        heading.setBounds(30, 20, 340, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 14));
        add(heading);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 80, 100, 25);
        add(userLabel);

        userText = new JTextField();
        userText.setBounds(150, 80, 180, 25);
        add(userText);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 120, 100, 25);
        add(passLabel);

        passText = new JPasswordField();
        passText.setBounds(150, 120, 180, 25);
        add(passText);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(80, 180, 100, 30);
        add(loginBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(200, 180, 100, 30);
        add(exitBtn);

        loginBtn.addActionListener(e -> login());
        exitBtn.addActionListener(e -> System.exit(0));
    }

    private void login() {
        String username = userText.getText();
        String password = String.valueOf(passText.getPassword());

        // Simple hard-coded login for demo
        if (username.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            dispose();
            new AdminDashboard().setVisible(true);
        } else if (username.equals("teacher") && password.equals("teacher")) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            dispose();
            new TeacherDashboard().setVisible(true); // Can create separate TeacherDashboard later
        } else if (username.equals("student") && password.equals("student")) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            dispose();
            String studentRoll = "S001"; // Example, can map from login
            new ViewResults(studentRoll).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
