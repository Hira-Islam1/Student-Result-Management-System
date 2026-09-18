package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewResults extends JFrame {

    JTable table;
    DefaultTableModel model;
    String studentRollFilter = null;

    public ViewResults() {
        this(null);
    }

    public ViewResults(String studentRoll) {
        this.studentRollFilter = studentRoll;
        setTitle("View Results");
        setSize(950, 450);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Table
        String[] columns = {"Student Roll", "Subject Code", "Mid", "Final", "Quiz", "Assignment", "Total", "Grade", "GPA"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 20, 850, 350);
        add(scrollPane);

        loadResults();
    }

    private void loadResults() {
        model.setRowCount(0); // Clear previous rows

        for (Marks m : MarksManagement.marksList) {
            if (studentRollFilter == null || m.studentRoll.equals(studentRollFilter)) {
                Object[] row = {m.studentRoll, m.subjectCode, m.midMarks, m.finalMarks, m.quizMarks,
                        m.assignmentMarks, m.totalMarks, m.grade, m.gpa};
                model.addRow(row);
            }
        }
    }
}
