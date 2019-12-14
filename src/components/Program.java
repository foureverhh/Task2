package components;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private String name;
    private List<Seminar> seminars;
    private ProgramCoordinator programCoordinator;

    public Program(String name) {
        this.name = name;
        seminars = new ArrayList<>();
    }

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        for (Seminar seminar : seminars){
            for(Attendance attendance : seminar.getAttendances()){
                if(!students.contains(attendance.getStudent()))
                    students.add(attendance.getStudent());
            }
        }
        return students;
    }

    public void addSeminar(Seminar seminar) {
        seminars.add(seminar);
    }

    public void removeSeminar(Seminar seminar) {
        seminars.remove(seminar);
    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public String getName() {
        return name;
    }

    public ProgramCoordinator getProgramCoordinator() {
        return programCoordinator;
    }

    public void setProgramCoordinator(ProgramCoordinator programCoordinator) {
        this.programCoordinator = programCoordinator;
    }
}
