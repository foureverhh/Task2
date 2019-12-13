package model;

public class Subject {
    private String name;

    public String viewSubjectInfo(){
        return "Subject is " + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
