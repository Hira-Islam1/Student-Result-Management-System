package gui;

import javax.swing.*;
import java.awt.*;

public class StudentManagement extends JFrame {

    JButton addBtn, viewBtn, backBtn;

    public StudentManagement() {
        setTitle("Student Management");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel heading = new JLabel("Student Management");
        heading.setBounds(200, 20, 300, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading);

        addBtn = new JButton("Add Student");
        addBtn.setBounds(200, 80, 200, 40);
        add(addBtn);

        viewBtn = new JButton("View Students");
        viewBtn.setBounds(200, 150, 200, 40);
        add(viewBtn);

        backBtn = new JButton("Back to Dashboard");
        backBtn.setBounds(200, 220, 200, 40);
        add(backBtn);

        addBtn.addActionListener(e -> new AddStudent().setVisible(true));
        viewBtn.addActionListener(e -> new ViewStudents().setVisible(true));
        backBtn.addActionListener(e -> dispose());
    }
}
