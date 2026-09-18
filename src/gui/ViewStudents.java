package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewStudents extends JFrame {

    JTable table;
    DefaultTableModel model;
    JButton editBtn, deleteBtn;

    public ViewStudents() {
        setTitle("View Students");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {"Roll No", "Name", "Department", "Semester"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        editBtn = new JButton("Edit Selected");
        deleteBtn = new JButton("Delete Selected");
        btnPanel.add(editBtn);
        btnPanel.add(deleteBtn);
        add(btnPanel, BorderLayout.SOUTH);

        loadStudents();

        editBtn.addActionListener(e -> editStudent());
        deleteBtn.addActionListener(e -> deleteStudent());
    }

    private void loadStudents() {
        model.setRowCount(0);
        for (Student s : AddStudent.students) {
            Object[] row = {s.rollNo, s.name, s.department, s.semester};
            model.addRow(row);
        }
    }

    private void editStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            Student s = AddStudent.students.get(selectedRow);
            JTextField rollField = new JTextField(s.rollNo);
            JTextField nameField = new JTextField(s.name);
            JTextField deptField = new JTextField(s.department);
            JTextField semField = new JTextField(s.semester);

            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Roll No:"));
            panel.add(rollField);
            panel.add(new JLabel("Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Department:"));
            panel.add(deptField);
            panel.add(new JLabel("Semester:"));
            panel.add(semField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Edit Student", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                s.rollNo = rollField.getText();
                s.name = nameField.getText();
                s.department = deptField.getText();
                s.semester = semField.getText();
                loadStudents();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to edit!");
        }
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                AddStudent.students.remove(selectedRow);
                loadStudents();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to delete!");
        }
    }
}
