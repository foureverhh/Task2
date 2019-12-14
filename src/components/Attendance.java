package components;

public class Attendance {
    private boolean attendanceLevel;
    private Seminar seminar;
    private Student student;

    public Attendance() {
    }

    public void registerAttendance(Seminar seminar, Student student){
        attendanceLevel = true;
        this.seminar = seminar;
        this.seminar.getAttendances().add(this);
        this.student = student;
        this.student.attendSeminar(this);
    }

    public void removeAttendance(Seminar seminar, Student student){
        seminar.getAttendances().remove(this);
        student.getAttendances().remove(this);
        attendanceLevel = false;
    }

    public Seminar getSeminar() {
        return seminar;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "student=" + student +
                '}';
    }
}
