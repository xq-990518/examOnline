package entity;

import java.util.List;

//学生类
public class Student {
    private int s_id;
    private String s_No;
    private String s_Name;
    private TClass tClass;
    private List<Achievement> achievements;

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public TClass gettClass() {
        return tClass;
    }

    public void settClass(TClass tClass) {
        this.tClass = tClass;
    }

    public String getS_No() {
        return s_No;
    }

    public void setS_No(String s_No) {
        this.s_No = s_No;
    }

    public String getS_Name() {
        return s_Name;
    }

    public void setS_Name(String s_Name) {
        this.s_Name = s_Name;
    }

    public Student(int s_id, String s_No, String s_Name, TClass tClass, List<Achievement> achievements) {
        this.s_id = s_id;
        this.s_No = s_No;
        this.s_Name = s_Name;
        this.tClass = tClass;
        this.achievements = achievements;
    }

    public Student() {
    }
}
