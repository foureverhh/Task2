package view;

import controller.Attendance;
import model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Demo  {
    private static JFrame demo ;
    private static List<Student>  students;
    private static List<Seminar> seminars;
    private static List<Teacher> teachers;
    private static List<Subject> subjects;


    private static Program java19 ;
    private static ProgramCoordinator sara ;

    private static Seminar objectOrientedProgramming;
    private static Seminar objectAnalyseDesign;

    private static Subject useCaseDiagram;
    private static Subject sequenceDiagram;
    private static Subject socketProgramming;
    private static Subject guiProgramming;

    private static Student stu1;
    private static Student stu2;
    private static Student stu3;
    private static Student stu4;


    private static Teacher robert;
    private static Teacher sigrun;

    public static void main(String[] args) {
        demo = new JFrame("Seminar Demo");

        initData();

        Attendance attendance1 = new Attendance();
        attendance1.registerAttendance(objectOrientedProgramming, stu4);
        System.out.println("Seminar attendance: " + objectOrientedProgramming);
        System.out.println("Seminar total Attendance " + objectOrientedProgramming.getTotalAttendance());
        System.out.println("Student SeminarAttended(): " + stu4.getSeminarsAttended());

    }

    static void initData(){
        students = new ArrayList<>();
        seminars = new ArrayList<>();

        //init program coordinator and program
        java19 = new Program("JAVA19");
        sara = new ProgramCoordinator("Sara",java19);
        java19.setProgramCoordinator(sara);

        //init two seminars
        initSeminars();

        //init subjects
        initSubjects();

        //init students
        initStudents();

        //init teachers
        initTeachers();
    }

    static void initSeminars(){
        seminars = new ArrayList<>();
        objectOrientedProgramming = new Seminar("Object Oriented Programming",java19);
        objectAnalyseDesign = new Seminar("Object Analyse Design",java19);
        seminars.add(objectAnalyseDesign);
        seminars.add(objectOrientedProgramming);
    }

    static void initSubjects(){
        subjects = new ArrayList<>();

        useCaseDiagram = new Subject("Use Case Diagram",objectAnalyseDesign);
        sequenceDiagram = new Subject("Sequence Diagram",objectAnalyseDesign);
        socketProgramming = new Subject("Socket Programming",objectOrientedProgramming);
        guiProgramming = new Subject("GUI Programming",objectOrientedProgramming);

        subjects.add(useCaseDiagram);
        subjects.add(sequenceDiagram);
        subjects.add(socketProgramming);
        subjects.add(guiProgramming);
    }

    static void initStudents(){
        students = new ArrayList<>();

        stu4 = new Student("Stu1");
        stu1 = new Student("Stu2");
        stu2 = new Student("Stu3");
        stu3 = new Student("Stu4");

        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
    }

    static void initTeachers(){
        teachers = new ArrayList<>();

        robert = new Teacher("Robert");
        sigrun = new Teacher("Sigrun");
        robert.setCurrentSeminar(objectAnalyseDesign);
        sigrun.setCurrentSeminar(objectOrientedProgramming);
        objectOrientedProgramming.setTeacher(sigrun);
        objectAnalyseDesign.setTeacher(robert);
        teachers.add(robert);
        teachers.add(sigrun);
    }


}
