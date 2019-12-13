package model;

public class Subject {
    private String name;
    private Seminar seminar;

    public Subject(String name, Seminar seminar) {
        this.name = name;
        this.seminar = seminar;
        seminar.getSubjects().add(this);
    }

    public String viewSubjectInfo(){
        return "Welcome to subject " + name + " under " + seminar.getName() + "." ;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
