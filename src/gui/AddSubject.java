package gui;

import javax.swing.*;

public class AddSubject extends JFrame {

    JLabel nameLabel, codeLabel, semLabel, teacherLabel;
    JTextField nameText, codeText, semText, teacherText;
    JButton saveBtn, backBtn;

    public AddSubject() {
        setTitle("Add Subject");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel heading = new JLabel("Add Subject");
        heading.setBounds(140, 20, 200, 30);
        add(heading);

        nameLabel = new JLabel("Subject Name:");
        nameLabel.setBounds(50, 80, 120, 25);
        add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(180, 80, 180, 25);
        add(nameText);

        codeLabel = new JLabel("Subject Code:");
        codeLabel.setBounds(50, 120, 120, 25);
        add(codeLabel);

        codeText = new JTextField();
        codeText.setBounds(180, 120, 180, 25);
        add(codeText);

        semLabel = new JLabel("Semester:");
        semLabel.setBounds(50, 160, 120, 25);
        add(semLabel);

        semText = new JTextField();
        semText.setBounds(180, 160, 180, 25);
        add(semText);

        teacherLabel = new JLabel("Assigned Teacher:");
        teacherLabel.setBounds(50, 200, 120, 25);
        add(teacherLabel);

        teacherText = new JTextField();
        teacherText.setBounds(180, 200, 180, 25);
        add(teacherText);

        saveBtn = new JButton("Save");
        saveBtn.setBounds(80, 270, 100, 30);
        add(saveBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 270, 100, 30);
        add(backBtn);

        saveBtn.addActionListener(e -> saveSubject());
        backBtn.addActionListener(e -> dispose());
    }

    private void saveSubject() {
        String name = nameText.getText();
        String code = codeText.getText();
        String sem = semText.getText();
        String teacher = teacherText.getText();

        if (name.isEmpty() || code.isEmpty() || sem.isEmpty() || teacher.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
        } else {
            Subject s = new Subject(name, code, sem, teacher);
            CourseSubjectManagement.subjects.add(s);
            JOptionPane.showMessageDialog(this, "Subject added successfully!");
            nameText.setText("");
            codeText.setText("");
            semText.setText("");
            teacherText.setText("");
        }
    }
}
