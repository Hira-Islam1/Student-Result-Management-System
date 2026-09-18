package gui;

import javax.swing.*;
import java.awt.*;

public class TeacherDashboard extends JFrame {

    JButton marksBtn, viewResultsBtn, reportsBtn, logoutBtn;

    public TeacherDashboard() {
        setTitle("Teacher Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Teacher Dashboard");
        heading.setBounds(200, 20, 300, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading);

        marksBtn = new JButton("Enter Marks");
        marksBtn.setBounds(200, 80, 200, 40);
        add(marksBtn);

        viewResultsBtn = new JButton("View Results");
        viewResultsBtn.setBounds(200, 130, 200, 40);
        add(viewResultsBtn);

        reportsBtn = new JButton("Reports & Analysis");
        reportsBtn.setBounds(200, 180, 200, 40);
        add(reportsBtn);

        logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(200, 230, 200, 40);
        add(logoutBtn);

        // Button actions
        marksBtn.addActionListener(e -> new MarksManagement().setVisible(true));
        viewResultsBtn.addActionListener(e -> new ViewResults().setVisible(true));
        reportsBtn.addActionListener(e -> new ReportsAnalysis().setVisible(true));
        logoutBtn.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });
    }
}
