package components;

import java.util.ArrayList;
import java.util.List;

public class Seminar {
    private String name;
    private Teacher teacher;
    private List<Subject> subjects;
    private List<Attendance> attendances;
    private Program program;

    public Seminar() {
        subjects = new ArrayList<>();
        attendances = new ArrayList<>();
    }

    public Seminar(String name,Program program) {
        this.name = name;
        this.program = program;
        subjects = new ArrayList<>();
        attendances = new ArrayList<>();
    }

    public Seminar(Program program, String name, List<Attendance> attendances) throws Exception {
        this.program = program;
        this.name = name;
        this.attendances = attendances;
        if(attendances.size() == 0){
            throw new Exception("Attendances can not be zero");
        }
    }

    public Seminar(String name, Teacher teacher, Program program) {
        this.name = name;
        this.teacher = teacher;
        this.program = program;
        attendances = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    public int getTotalAttendance(){
        return attendances.size();
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public Program getProgram() {
        return program;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "Seminar info: " +
                "title: " + name + " , " +
                "teacher: " + teacher +
                " , attendances: " + attendances +
                " , program: " + program + " .";
    }
}
