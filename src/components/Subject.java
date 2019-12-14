package components;

public class Subject {
    private String name;
    private Seminar seminar;

    public Subject(String name, Seminar seminar) {
        this.name = name;
        this.seminar = seminar;
        seminar.getSubjects().add(this);
    }

    public String viewSubjectInfo(){
        return  name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
