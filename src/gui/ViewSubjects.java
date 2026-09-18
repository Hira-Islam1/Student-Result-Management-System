package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewSubjects extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewSubjects() {
        setTitle("View Subjects");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {"Subject Code", "Subject Name", "Semester", "Assigned Teacher"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        loadSubjects();
    }

    private void loadSubjects() {
        model.setRowCount(0);
        for (Subject s : CourseSubjectManagement.subjects) {
            Object[] row = {s.subjectCode, s.subjectName, s.semester, s.assignedTeacher};
            model.addRow(row);
        }
    }
}

