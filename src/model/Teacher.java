package model;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String name;
    private List<Seminar> seminarHistory;
    private Seminar currentSeminar;

    public Teacher(String name) {
        this.name = name;
        seminarHistory = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeminarHistory(List<Seminar> seminarHistory) {
        this.seminarHistory = seminarHistory;
    }

    public void setCurrentSeminar(Seminar currentSeminar) {
        this.currentSeminar = currentSeminar;
        seminarHistory.add(currentSeminar);
    }

    public List<Seminar> getSeminarHistory(){
        if(seminarHistory.size()>1)
            return seminarHistory.subList(1,seminarHistory.size()-1);
        else
            return seminarHistory;
    }
    public Seminar getCurrentSeminar(){
        return currentSeminar;
    }

    public String getName() {
        return name;
    }
}
