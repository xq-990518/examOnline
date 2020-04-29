package biz;

import entity.Administor;
import entity.Student;
import entity.Teacher;

public interface LoginBiz {
    Student getSLog(String sNo);
    Teacher getTLog(String tNo, String tPassword);
    Administor getALog(String admin_no, String password);
}
