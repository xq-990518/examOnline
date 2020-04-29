package entity;

import java.util.List;

//老师类
public class Teacher {
    private int t_id;
    private String t_No;
    private String t_Name;
    private String t_password;
    private Subject subject;
    private List<TClass> tClasses;

    public List<TClass> gettClasses() {
        return tClasses;
    }

    public void settClasses(List<TClass> tClasses) {
        this.tClasses = tClasses;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_No() {
        return t_No;
    }

    public void setT_No(String t_No) {
        this.t_No = t_No;
    }

    public String getT_Name() {
        return t_Name;
    }

    public void setT_Name(String t_Name) {
        this.t_Name = t_Name;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher(String t_No, String t_password) {
        this.t_No = t_No;
        this.t_password = t_password;
    }

    public Teacher(int t_id, String t_No, String t_Name, String t_password, Subject subject) {
        this.t_id = t_id;
        this.t_No = t_No;
        this.t_Name = t_Name;
        this.t_password = t_password;
        this.subject = subject;
    }

    public Teacher(int t_id, String t_No, String t_Name, String t_password, Subject subject, List<TClass> tClasses) {
        this.t_id = t_id;
        this.t_No = t_No;
        this.t_Name = t_Name;
        this.t_password = t_password;
        this.subject = subject;
        this.tClasses = tClasses;
    }

    public Teacher() {
    }
}