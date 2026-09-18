package gui;

public class Student {
    String rollNo;
    String name;
    String department;
    String semester;

    public Student(String rollNo, String name, String department, String semester) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return rollNo + " - " + name + " - " + department + " - " + semester;
    }
}
