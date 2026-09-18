package gui;

public class Marks {
    public String studentRoll;
    public String subjectCode;
    public double midMarks, finalMarks, quizMarks, assignmentMarks, totalMarks;
    public String grade;
    public double gpa; // Frontend placeholder

    public Marks(String studentRoll, String subjectCode, double mid, double fin, double quiz, double assign) {
        this.studentRoll = studentRoll;
        this.subjectCode = subjectCode;
        this.midMarks = mid;
        this.finalMarks = fin;
        this.quizMarks = quiz;
        this.assignmentMarks = assign;

        totalMarks = mid + fin + quiz + assign;

        // Simple grade calculation with GPA
        if (totalMarks >= 90) { grade = "A+"; gpa = 4.0; }
        else if (totalMarks >= 80) { grade = "A"; gpa = 3.7; }
        else if (totalMarks >= 70) { grade = "B"; gpa = 3.0; }
        else if (totalMarks >= 60) { grade = "C"; gpa = 2.0; }
        else if (totalMarks >= 50) { grade = "D"; gpa = 1.0; }
        else { grade = "F"; gpa = 0.0; }
    }
}
