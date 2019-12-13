package view;

import control.Attendance;
import model.Program;
import model.Seminar;
import model.Student;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Student1");
        Student student2 = new Student("Student2");
        Student student3 = new Student("Student3");
        Student student4 = new Student("Student4");
        Student student5 = new Student("Student5");

        //Create the program
        Program java19 = new Program("java19");

        //Create Attendance
        Attendance attendance = new Attendance();

        //Create seminars, accept attendance to make a seminar
        Seminar seminar = new Seminar();

        //add seminar to program
    }
}
