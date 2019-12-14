package demo;

import components.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Demo {
    //gui components
    private static JFrame demo;
    private static JPanel studentInfo;
    private static JPanel seminarInfo;
    private static JPanel attendanceInfo;
    private static JPanel buttonPanel;
    private static JPanel container;
    private static JScrollPane scrollPane;

    private static JCheckBox student1;
    private static JCheckBox student2;
    private static JCheckBox student3;
    private static JCheckBox student4;

    private static JCheckBox seminar1;
    private static JCheckBox seminar2;

    private static JButton check_result;

    private static JTextArea result;

    //class fields
    private static List<Student> students;
    private static List<Seminar> seminars;
    private static List<Teacher> teachers;
    private static List<Subject> subjects;
    private static List<Attendance> attendances;


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
        initData();
        guiConfig();
        //System.out.println("Students:" + students.size() + "Seminars: " + seminars.size());
    }

    static void guiConfig(){
        demo = new JFrame("Seminar");
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

        //students check boxes
        student1 = new JCheckBox("Stu1");
        student2 = new JCheckBox("Stu2");
        student3 = new JCheckBox("Stu3");
        student4 = new JCheckBox("Stu4");

        student1.addItemListener(l->{
            if(l.getItemSelectable() == student1)
                students.add(stu1);
        });
        student2.addItemListener(l->{
            if(l.getItemSelectable() == student2)
                students.add(stu2);
        });
        student3.addItemListener(l->{
            if(l.getItemSelectable() == student3)
                students.add(stu3);
        });
        student4.addItemListener(l->{
            if(l.getItemSelectable() == student4)
                students.add(stu4);
        });

        studentInfo.add(student1);
        studentInfo.add(student2);
        studentInfo.add(student3);
        studentInfo.add(student4);

        //seminars check boxes
        seminar1 = new JCheckBox("Object Oriented Programming");
        seminar2 = new JCheckBox("Object Analyze and Design");
        seminar1.addItemListener(l ->{
            if(l.getItemSelectable() == seminar1){
                seminars.add(objectOrientedProgramming);
            }
        });
        seminar2.addItemListener(l -> {
            if(l.getItemSelectable() == seminar2){
                seminars.add(objectAnalyseDesign);
            }
        });
        seminarInfo.add(seminar1);
        seminarInfo.add(seminar2);

        //button
        check_result = new JButton("Check Attendance Result");
        check_result.addActionListener(l->{
            attendances = new ArrayList<>();
            for(Student student : students){
                result.append("\n");
                for(Seminar seminar : seminars){
                    Attendance attendance = new Attendance();
                    attendance.registerAttendance(seminar,student);
                    result.append(student.getName() + " attended seminar " + seminar.getName() + " ,with subjects: " + seminar.getSubjects().get(0).viewSubjectInfo() +
                            " and " + seminar.getSubjects().get(1).viewSubjectInfo() + " ,taught by teacher " + seminar.getTeacher() + "\n");
                    attendances.add(attendance);
                }
            }
            result.append("\n" + "***********************************" + "\n");
        });
        buttonPanel.add(check_result);

        //attendance info
        result = new JTextArea(35,60);
        //attendanceInfo.setLayout(new BoxLayout(attendanceInfo,BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(result);
        attendanceInfo.add(scrollPane);

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