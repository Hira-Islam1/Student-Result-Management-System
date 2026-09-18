package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddStudent extends JFrame {

    JLabel rollLabel, nameLabel, deptLabel, semLabel;
    JTextField rollText, nameText, deptText, semText;
    JButton saveBtn, backBtn;

    // Store students in memory
    public static ArrayList<Student> students = new ArrayList<>();

    public AddStudent() {
        setTitle("Add Student");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel heading = new JLabel("Add Student");
        heading.setBounds(180, 20, 200, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading);

        rollLabel = new JLabel("Roll No:");
        rollLabel.setBounds(50, 80, 100, 25);
        add(rollLabel);

        rollText = new JTextField();
        rollText.setBounds(150, 80, 200, 25);
        add(rollText);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 120, 100, 25);
        add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(150, 120, 200, 25);
        add(nameText);

        deptLabel = new JLabel("Department:");
        deptLabel.setBounds(50, 160, 100, 25);
        add(deptLabel);

        deptText = new JTextField();
        deptText.setBounds(150, 160, 200, 25);
        add(deptText);

        semLabel = new JLabel("Semester:");
        semLabel.setBounds(50, 200, 100, 25);
        add(semLabel);

        semText = new JTextField();
        semText.setBounds(150, 200, 200, 25);
        add(semText);

        saveBtn = new JButton("Save");
        saveBtn.setBounds(100, 260, 100, 30);
        add(saveBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(250, 260, 100, 30);
        add(backBtn);

        saveBtn.addActionListener(e -> saveStudent());
        backBtn.addActionListener(e -> dispose());
    }

    private void saveStudent() {
        String roll = rollText.getText();
        String name = nameText.getText();
        String dept = deptText.getText();
        String sem = semText.getText();

        if (roll.isEmpty() || name.isEmpty() || dept.isEmpty() || sem.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
        } else {
            Student s = new Student(roll, name, dept, sem);
            students.add(s);
            JOptionPane.showMessageDialog(this, "Student added successfully!");
            clearFields();
        }
    }

    private void clearFields() {
        rollText.setText("");
        nameText.setText("");
        deptText.setText("");
        semText.setText("");
    }
}
