package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewCourses extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewCourses() {
        setTitle("View Courses");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {"Course Code", "Course Name"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        loadCourses();
    }

    private void loadCourses() {
        model.setRowCount(0);
        for (Course c : CourseSubjectManagement.courses) {
            Object[] row = {c.courseCode, c.courseName};
            model.addRow(row);
        }
    }
}
