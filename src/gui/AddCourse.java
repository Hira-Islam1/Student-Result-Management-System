package gui;

import javax.swing.*;

public class AddCourse extends JFrame {

    JLabel nameLabel, codeLabel;
    JTextField nameText, codeText;
    JButton saveBtn, backBtn;

    public AddCourse() {
        setTitle("Add Course");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel heading = new JLabel("Add Course");
        heading.setBounds(150, 20, 200, 30);
        add(heading);

        nameLabel = new JLabel("Course Name:");
        nameLabel.setBounds(50, 80, 100, 25);
        add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(160, 80, 180, 25);
        add(nameText);

        codeLabel = new JLabel("Course Code:");
        codeLabel.setBounds(50, 120, 100, 25);
        add(codeLabel);

        codeText = new JTextField();
        codeText.setBounds(160, 120, 180, 25);
        add(codeText);

        saveBtn = new JButton("Save");
        saveBtn.setBounds(80, 180, 100, 30);
        add(saveBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 180, 100, 30);
        add(backBtn);

        saveBtn.addActionListener(e -> saveCourse());
        backBtn.addActionListener(e -> dispose());
    }

    private void saveCourse() {
        String name = nameText.getText();
        String code = codeText.getText();

        if (name.isEmpty() || code.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
        } else {
            Course c = new Course(name, code);
            CourseSubjectManagement.courses.add(c);
            JOptionPane.showMessageDialog(this, "Course added successfully!");
            nameText.setText("");
            codeText.setText("");
        }
    }
}
