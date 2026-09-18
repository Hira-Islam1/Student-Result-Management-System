package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.PrinterException;

public class ReportsAnalysis extends JFrame {

    JTable table;
    DefaultTableModel model;
    JButton printBtn, backBtn;
    JTextArea analysisArea;

    public ReportsAnalysis() {
        setTitle("Reports & Analysis");
        setSize(950, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Table
        String[] columns = {"Student Roll", "Subject Code", "Total Marks", "Grade", "GPA"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Analysis Panel
        analysisArea = new JTextArea(5, 30);
        analysisArea.setText("Class Average: 0\nHighest Marks: 0\nLowest Marks: 0\nGrade Distribution:\nA+:0 A:0 B:0 ...");
        analysisArea.setEditable(false);
        add(new JScrollPane(analysisArea), BorderLayout.SOUTH);

        // Button Panel
        JPanel btnPanel = new JPanel();
        printBtn = new JButton("Print Report");
        backBtn = new JButton("Back");
        btnPanel.add(printBtn);
        btnPanel.add(backBtn);
        add(btnPanel, BorderLayout.EAST);

        loadReport();

        // Button actions
        printBtn.addActionListener(e -> printReport());
        backBtn.addActionListener(e -> dispose());
    }

    private void loadReport() {
        model.setRowCount(0);
        for (Marks m : MarksManagement.marksList) {
            Object[] row = {m.studentRoll, m.subjectCode, m.totalMarks, m.grade, m.gpa};
            model.addRow(row);
        }
    }

    private void printReport() {
        try {
            boolean complete = table.print();
            if (complete) {
                JOptionPane.showMessageDialog(this, "Report sent to printer successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Printing canceled!");
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Printing failed: " + ex.getMessage());
        }
    }
}

