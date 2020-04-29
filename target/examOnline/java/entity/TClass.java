package entity;

import java.util.List;

public class TClass {
    private int c_id;
    private String c_name;
    private List<Student> students;
    private List<Teacher> teachers;

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public TClass(int c_id, String c_name, List<Student> students) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.students = students;
    }

    public TClass(int c_id, String c_name, List<Student> students, List<Teacher> teachers) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.students = students;
        this.teachers = teachers;
    }

    public TClass(int c_id, String c_name) {
        this.c_id = c_id;
        this.c_name = c_name;
    }

    public TClass() {
    }
}
