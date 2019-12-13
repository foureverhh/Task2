package model;

import java.util.List;
import model.Program;
import model.Teacher;

public class ProgramCoordinator {
    private String name;
    private Program program;
    private List<Teacher> teachers;

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public Teacher findTeacher(String teacherName){
        Teacher t = null;
        for(Teacher teacher : teachers){
            if(teacher.getName().equalsIgnoreCase(teacherName.trim())){
                t = teacher;
            }
        }
        return t;
    }

    public String getName() {
        return name;
    }

    public Program getProgram() {
        return program;
    }


    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
