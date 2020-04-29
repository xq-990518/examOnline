package entity;

import java.util.List;

//试卷类
public class Exam {
    private int e_id;
    private String e_name;
    private int e_examDate;
    private int e_type;
    private Subject discipline;
    private List<Question> questions;
    private List<Achievement> achievements;

    public int getE_type() {
        return e_type;
    }

    public void setE_type(int e_type) {
        this.e_type = e_type;
    }

    public Subject getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Subject discipline) {
        this.discipline = discipline;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public int getE_examDate() {
        return e_examDate;
    }

    public void setE_examDate(int e_examDate) {
        this.e_examDate = e_examDate;
    }

    public Exam(int e_id, String e_name, int e_examDate, List<Question> questions, List<Achievement> achievements) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_examDate = e_examDate;
        this.questions = questions;
        this.achievements = achievements;
    }

    public Exam(int e_id, String e_name, int e_examDate, Subject discipline, List<Question> questions, List<Achievement> achievements) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_examDate = e_examDate;
        this.discipline = discipline;
        this.questions = questions;
        this.achievements = achievements;
    }

    public Exam(int e_id, String e_name, int e_examDate, int e_type, Subject discipline, List<Question> questions, List<Achievement> achievements) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_examDate = e_examDate;
        this.e_type = e_type;
        this.discipline = discipline;
        this.questions = questions;
        this.achievements = achievements;
    }

    public Exam() {
    }
}
