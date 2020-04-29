package entity;

import java.util.Date;

//考试信息类
public class Achievement {
    private int a_id;
    private int mark;
    private Date a_date;
    private Student student;
    private Exam exam;

    public Date getA_date() {
        return a_date;
    }

    public void setA_date(Date a_date) {
        this.a_date = a_date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Achievement(int a_id) {
        this.a_id = a_id;
    }

    public Achievement(int a_id, int mark) {
        this.a_id = a_id;
        this.mark = mark;
    }

    public Achievement(int a_id, Student student, int mark) {
        this.a_id = a_id;
        this.student = student;
        this.mark = mark;
    }

    public Achievement(int a_id, int mark, Date a_date, Student student) {
        this.a_id = a_id;
        this.mark = mark;
        this.a_date = a_date;
        this.student = student;
    }

    public Achievement() {
    }
}
