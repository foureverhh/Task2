package view;

import controller.Attendance;
import model.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Demo  {
    //gui components
    private static JFrame demo;
    private static JPanel studentInfo;
    private static JPanel seminarInfo;
    private static JPanel attendanceInfo;
    private static JPanel buttonPanel;
    private static JPanel container;

    private static JRadioButton student1;
    private static JRadioButton student2;
    private static JRadioButton student3;
    private static JRadioButton student4;
    private static ButtonGroup student_group;

    private static JRadioButton seminar1;
    private static JRadioButton seminar2;
    private static ButtonGroup seminar_group;

    private static JButton check_result;

    private static JTextArea result;

    //class fields
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
        //Init all java class instances
        initData();
        guiConfig();

 /*       Attendance attendance1 = new Attendance();
        attendance1.registerAttendance(objectOrientedProgramming, stu4);
        System.out.println("Seminar attendance: " + objectOrientedProgramming);
        System.out.println("Seminar total Attendance " + objectOrientedProgramming.getTotalAttendance());
        System.out.println("Student SeminarAttended(): " + stu4.getSeminarsAttended());*/

    }

    static void guiConfig(){
        demo = new JFrame("Seminar Demo");
        demo.setSize(800,800);
        demo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        demo.setLocationRelativeTo(null);

        //panels
        container = new JPanel();
        studentInfo = new JPanel();
        studentInfo.setBorder(BorderFactory.createTitledBorder("Students"));
        seminarInfo = new JPanel();
        seminarInfo.setBorder(BorderFactory.createTitledBorder("Seminars"));
        buttonPanel = new JPanel();
        attendanceInfo = new JPanel();
        attendanceInfo.setBorder(BorderFactory.createTitledBorder("Attendance"));

        //students radio buttons
        student1 = new JRadioButton("Stu1");
        student1.setSelected(true);
        student2 = new JRadioButton("Stu2");
        student3 = new JRadioButton("Stu3");
        student4 = new JRadioButton("Stu4");
        ButtonGroup student_group = new ButtonGroup();
        student_group.add(student1);
        student_group.add(student2);
        student_group.add(student3);
        student_group.add(student4);
        studentInfo.add(student1);
        studentInfo.add(student2);
        studentInfo.add(student3);
        studentInfo.add(student4);

        //seminars radio buttons
        seminar1 = new JRadioButton("Object Oriented Programming");
        seminar1.setSelected(true);
        seminar2 = new JRadioButton("Object Analyze and Design");
        seminar_group = new ButtonGroup();
        student_group.add(student1);
        student_group.add(student2);
        seminarInfo.add(seminar1);
        seminarInfo.add(seminar2);

        //button
        check_result = new JButton("Check Attendance Result");
        buttonPanel.add(check_result);

        //attendance info
        result = new JTextArea(60,60);
        //attendanceInfo.setLayout(new BoxLayout(attendanceInfo,BoxLayout.Y_AXIS));
        attendanceInfo.add(result);

        container.add(studentInfo);
        container.add(seminarInfo);
        container.add(buttonPanel);
        container.add(attendanceInfo);
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        demo.add(container);
        demo.setVisible(true);
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
