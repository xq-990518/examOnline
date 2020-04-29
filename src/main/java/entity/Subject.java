package entity;

import java.util.List;

public class Subject {
    private int Subject_id;
    private String Subject_name;
    private List<Teacher> teachers;
    private List<Exam> exams;
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }


    public int getSubject_id() {
        return Subject_id;
    }

    public void setSubject_id(int subject_id) {
        Subject_id = subject_id;
    }

    public String getSubject_name() {
        return Subject_name;
    }

    public void setSubject_name(String subject_name) {
        Subject_name = subject_name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Subject() {
    }

    public Subject(int subject_id) {
        Subject_id = subject_id;
    }

    public Subject(int subject_id, String subject_name) {
        Subject_id = subject_id;
        Subject_name = subject_name;
    }

    public Subject(int subject_id, String subject_name, List<Teacher> teachers, List<Exam> exams, List<Question> questions) {
        Subject_id = subject_id;
        Subject_name = subject_name;
        this.teachers = teachers;
        this.exams = exams;
        this.questions = questions;
    }

}
