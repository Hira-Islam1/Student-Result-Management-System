package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MarksManagement extends JFrame {

    public static ArrayList<Marks> marksList = new ArrayList<>();
    JButton addBtn, editBtn, deleteBtn, backBtn;

    public MarksManagement() {
        setTitle("Marks & Result Management");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel heading = new JLabel("Marks & Result Management");
        heading.setBounds(150, 20, 400, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        add(heading);

        addBtn = new JButton("Add Marks");
        addBtn.setBounds(200, 80, 200, 40);
        add(addBtn);

        editBtn = new JButton("Edit Marks");
        editBtn.setBounds(200, 140, 200, 40);
        add(editBtn);

        deleteBtn = new JButton("Delete Marks");
        deleteBtn.setBounds(200, 200, 200, 40);
        add(deleteBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 260, 200, 40);
        add(backBtn);

        // Button actions
        addBtn.addActionListener(e -> addMarks());
        editBtn.addActionListener(e -> editMarks());
        deleteBtn.addActionListener(e -> deleteMarks());
        backBtn.addActionListener(e -> dispose());
    }

    // ------------------ Add Marks ------------------
    private void addMarks() {
        JTextField rollField = new JTextField();
        JTextField subjectField = new JTextField();
        JTextField midField = new JTextField();
        JTextField finalField = new JTextField();
        JTextField quizField = new JTextField();
        JTextField assignField = new JTextField();

        Object[] fields = {
                "Student Roll:", rollField,
                "Subject Code:", subjectField,
                "Mid Marks:", midField,
                "Final Marks:", finalField,
                "Quiz Marks:", quizField,
                "Assignment Marks:", assignField
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Add Marks", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            try {
                Marks m = new Marks(
                        rollField.getText(),
                        subjectField.getText(),
                        Double.parseDouble(midField.getText()),
                        Double.parseDouble(finalField.getText()),
                        Double.parseDouble(quizField.getText()),
                        Double.parseDouble(assignField.getText())
                );
                marksList.add(m);
                JOptionPane.showMessageDialog(this, "Marks added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter numbers for marks.");
            }
        }
    }

    // ------------------ Edit Marks ------------------
    private void editMarks() {
        String roll = JOptionPane.showInputDialog(this, "Enter Student Roll to Edit:");
        String subject = JOptionPane.showInputDialog(this, "Enter Subject Code:");

        if (roll == null || subject == null) return;

        Marks found = null;
        for (Marks m : marksList) {
            if (m.studentRoll.equals(roll) && m.subjectCode.equals(subject)) {
                found = m;
                break;
            }
        }

        if (found == null) {
            JOptionPane.showMessageDialog(this, "Marks not found for this student and subject!");
            return;
        }

        JTextField midField = new JTextField(String.valueOf(found.midMarks));
        JTextField finalField = new JTextField(String.valueOf(found.finalMarks));
        JTextField quizField = new JTextField(String.valueOf(found.quizMarks));
        JTextField assignField = new JTextField(String.valueOf(found.assignmentMarks));

        Object[] fields = {
                "Mid Marks:", midField,
                "Final Marks:", finalField,
                "Quiz Marks:", quizField,
                "Assignment Marks:", assignField
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Edit Marks", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            try {
                found.midMarks = Double.parseDouble(midField.getText());
                found.finalMarks = Double.parseDouble(finalField.getText());
                found.quizMarks = Double.parseDouble(quizField.getText());
                found.assignmentMarks = Double.parseDouble(assignField.getText());
                found.totalMarks = found.midMarks + found.finalMarks + found.quizMarks + found.assignmentMarks;

                // Recalculate grade and GPA
                if (found.totalMarks >= 90) { found.grade = "A+"; found.gpa = 4.0; }
                else if (found.totalMarks >= 80) { found.grade = "A"; found.gpa = 3.7; }
                else if (found.totalMarks >= 70) { found.grade = "B"; found.gpa = 3.0; }
                else if (found.totalMarks >= 60) { found.grade = "C"; found.gpa = 2.0; }
                else if (found.totalMarks >= 50) { found.grade = "D"; found.gpa = 1.0; }
                else { found.grade = "F"; found.gpa = 0.0; }

                JOptionPane.showMessageDialog(this, "Marks updated successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter numbers for marks.");
            }
        }
    }

    // ------------------ Delete Marks ------------------
    private void deleteMarks() {
        String roll = JOptionPane.showInputDialog(this, "Enter Student Roll to Delete:");
        String subject = JOptionPane.showInputDialog(this, "Enter Subject Code:");

        if (roll == null || subject == null) return;

        Marks found = null;
        for (Marks m : marksList) {
            if (m.studentRoll.equals(roll) && m.subjectCode.equals(subject)) {
                found = m;
                break;
            }
        }

        if (found == null) {
            JOptionPane.showMessageDialog(this, "Marks not found for this student and subject!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            marksList.remove(found);
            JOptionPane.showMessageDialog(this, "Marks deleted successfully!");
        }
    }
}

