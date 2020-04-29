package biz;

import entity.Page;
import entity.Student;
import entity.TClass;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface StuManBiz {
    List<TClass> ShowClass();
    void InsStu(String s_No, String s_Name, int c_id);
    ModelAndView SelAllStu(int pageNo,String tip);
    ModelAndView StuById(String StuNo,int pageNo);
    ModelAndView StuByCla(int ClaId,int pageNo);
    ModelAndView StuByName(String StuName, int pageNo);
    Student ShowStuInfo(int StuId);
    ModelAndView UpdStu(int StuId, String StuNo, String StuName, int ClaId,int pageNo);
    boolean checkStudent(String StuNo);
    String checkUpdateStudent(int StuId,String StuNo);
    void DelStu(int StuId);
    void UpdStuByName(int StuId, String StuNo, String StuName, int ClaId,int pageNo);

    ModelAndView teacherSelectStudent(int t_id,int subject_id,int c_id,int pgaeNo);
}
