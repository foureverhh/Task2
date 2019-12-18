package demo;

import components.*;

import javax.swing.*;
import java.awt.event.ItemEvent;
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
    }

    static void guiConfig(){
        List<Student> students = new ArrayList<>();
        List<Seminar> seminars = new ArrayList<>();
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

        student1.addItemListener(su1->{
    /*        if(su1.getItemSelectable() == student1)
                students.add(stu1);*/
            if(su1.getStateChange() == ItemEvent.SELECTED){
                if(!students.contains(stu1))
                    students.add(stu1);
            }else {
                students.remove(stu1);
            }
        });
        student2.addItemListener(su2->{
            if(su2.getStateChange() == ItemEvent.SELECTED){
                if(!students.contains(stu2))
                    students.add(stu2);
            }else {
                //if(students.contains(stu2))
                    students.remove(stu2);
            }
        });
        student3.addItemListener(su3->{
            if(su3.getStateChange() == ItemEvent.SELECTED){
                if(!students.contains(stu3))
                    students.add(stu3);
            }else {
                //if(students.contains(stu3))
                    students.remove(stu3);
            }
        });
        student4.addItemListener(su4->{
            if(su4.getStateChange() == ItemEvent.SELECTED){
                if(!students.contains(stu4))
                    students.add(stu4);
            }else {
                //if(students.contains(stu4))
                    students.remove(stu4);
            }
        });

        studentInfo.add(student1);
        studentInfo.add(student2);
        studentInfo.add(student3);
        studentInfo.add(student4);

        //seminars check boxes
        seminar1 = new JCheckBox("Object Oriented Programming");
        seminar2 = new JCheckBox("Object Analyze and Design");

        seminar1.addItemListener(se1 ->{
            if(se1.getStateChange() == ItemEvent.SELECTED){
                if(!seminars.contains(objectOrientedProgramming))
                    seminars.add(objectOrientedProgramming);
            }else {
                //if(seminars.contains(objectOrientedProgramming))
                    seminars.remove(objectOrientedProgramming);
            }
        });
        seminar2.addItemListener(se2 -> {
            if(se2.getStateChange() == ItemEvent.SELECTED){
                if(!seminars.contains(objectAnalyseDesign))
                    seminars.add(objectAnalyseDesign);
            }else {
                //if(seminars.contains(objectAnalyseDesign))
                    seminars.remove(objectAnalyseDesign);

            }
        });
        seminarInfo.add(seminar1);
        seminarInfo.add(seminar2);

        //button
        check_result = new JButton("Check Attendance Result");
        buttonPanel.add(check_result);
        check_result.addActionListener(l->{
            attendances = new ArrayList<>();
            for(Student student:students){
                //Empty all student's attended seminar
                student.getSeminarsAttended().clear();
            }
            for(Seminar seminar : seminars){
                //Empty seminar's attendance
                seminar.getAttendances().clear();
            }
            for(Student student : students){
                result.append("\n");
                for(Seminar seminar : seminars){
                    Attendance attendance = new Attendance();
                    attendance.registerAttendance(seminar,student);
                    result.append(student.getName() + " attends seminar " + seminar.getName() + " ,with subjects: " + seminar.getSubjects().get(0).viewSubjectInfo() +
                            " and " + seminar.getSubjects().get(1).viewSubjectInfo() + " ,taught by teacher " + seminar.getTeacher() + "\n");
                    if(!attendances.contains(attendance))
                        attendances.add(attendance);
                }
            }
            result.append("\n");
            for(Seminar seminar :seminars){
                result.append("\nTo Seminar: " + seminar.getName() + " , Attendances are: \n");
                result.append("There are total " + seminar.getTotalAttendance() + " attendances to seminar "+ seminar.getName() +"\n");
            }
            result.append("\n");
            for(Student student : students){
                result.append("\nTo Student, he or she " + student.getName() + " attends" + student.getSeminarsAttended().size() + " seminars: ");
                for(Seminar seminar : student.getSeminarsAttended()){
                    result.append(seminar.getName()+ " ");
                }
                result.append("\n");
            }
            result.append("\n" + "***********************************" + "\n");
        });


        //attendance info
        result = new JTextArea(35,60);
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
/*        students = new ArrayList<>();
        seminars = new ArrayList<>();*/

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
        //seminars = new ArrayList<>();
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
        //students = new ArrayList<>();
        stu1 = new Student("Stu1");
        stu2 = new Student("Stu2");
        stu3 = new Student("Stu3");
        stu4 = new Student("Stu4");
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
