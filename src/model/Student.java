package model;

import control.Attendance;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Attendance> attendances;

    public Student(String name) {
        this.name = name;
        attendances = new ArrayList<>();
    }

    public List<Seminar> getSeminarsAttended(){
        return null;
    }

    public String getName() {
        return name;
    }

    public void attendSeminar(Attendance attendance){
        this.attendances.add(attendance);
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }
}
