package gui;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    JButton studentBtn, courseSubjectBtn, marksBtn, viewResultsBtn, reportsBtn, logoutBtn;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Heading
        JLabel heading = new JLabel("Admin Dashboard");
        heading.setBounds(200, 20, 300, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading);

        // Buttons
        studentBtn = new JButton("Student Management");
        studentBtn.setBounds(200, 70, 200, 40);
        add(studentBtn);

        courseSubjectBtn = new JButton("Course & Subject Management");
        courseSubjectBtn.setBounds(200, 120, 200, 40);
        add(courseSubjectBtn);

        marksBtn = new JButton("Marks & Results");
        marksBtn.setBounds(200, 170, 200, 40);
        add(marksBtn);

        viewResultsBtn = new JButton("View Results");
        viewResultsBtn.setBounds(200, 220, 200, 40);
        add(viewResultsBtn);

        reportsBtn = new JButton("Reports & Analysis");
        reportsBtn.setBounds(200, 270, 200, 40);
        add(reportsBtn);

        logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(200, 320, 200, 40);
        add(logoutBtn);

        // Button actions
        studentBtn.addActionListener(e -> new StudentManagement().setVisible(true));
        courseSubjectBtn.addActionListener(e -> new CourseSubjectManagement().setVisible(true));
        marksBtn.addActionListener(e -> new MarksManagement().setVisible(true));
        viewResultsBtn.addActionListener(e -> new ViewResults().setVisible(true));
        reportsBtn.addActionListener(e -> new ReportsAnalysis().setVisible(true));
        logoutBtn.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });
    }
}
