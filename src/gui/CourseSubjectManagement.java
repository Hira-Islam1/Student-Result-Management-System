package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CourseSubjectManagement extends JFrame {

    JButton addCourseBtn, addSubjectBtn, viewCoursesBtn, viewSubjectsBtn, backBtn;

    public static ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<Subject> subjects = new ArrayList<>();

    public CourseSubjectManagement() {
        setTitle("Course & Subject Management");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel heading = new JLabel("Course & Subject Management");
        heading.setBounds(180, 20, 400, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading);

        addCourseBtn = new JButton("Add Course");
        addCourseBtn.setBounds(200, 80, 200, 40);
        add(addCourseBtn);

        addSubjectBtn = new JButton("Add Subject");
        addSubjectBtn.setBounds(200, 130, 200, 40);
        add(addSubjectBtn);

        viewCoursesBtn = new JButton("View Courses");
        viewCoursesBtn.setBounds(200, 180, 200, 40);
        add(viewCoursesBtn);

        viewSubjectsBtn = new JButton("View Subjects");
        viewSubjectsBtn.setBounds(200, 230, 200, 40);
        add(viewSubjectsBtn);

        backBtn = new JButton("Back to Dashboard");
        backBtn.setBounds(200, 280, 200, 40);
        add(backBtn);

        addCourseBtn.addActionListener(e -> new AddCourse().setVisible(true));
        addSubjectBtn.addActionListener(e -> new AddSubject().setVisible(true));
        viewCoursesBtn.addActionListener(e -> new ViewCourses().setVisible(true));
        viewSubjectsBtn.addActionListener(e -> new ViewSubjects().setVisible(true));
        backBtn.addActionListener(e -> dispose());
    }
}

