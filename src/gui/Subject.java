package gui;

public class Subject {
    String subjectName;
    String subjectCode;
    String semester;
    String assignedTeacher;

    public Subject(String subjectName, String subjectCode, String semester, String assignedTeacher) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.semester = semester;
        this.assignedTeacher = assignedTeacher;
    }

    @Override
    public String toString() {
        return subjectCode + " - " + subjectName + " (Semester: " + semester + ", Teacher: " + assignedTeacher + ")";
    }
}
