package biz;

import entity.Teacher;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface TeacherBiz {
    List<Teacher> getTeacher();
    ModelAndView save(Teacher teacher,String tclass);
    ModelAndView update(int pageNo,Teacher teacher,String tclass);
    ModelAndView list(int pageNo);
    ModelAndView listByName(int pageNo,String t_Name);
    ModelAndView listByNo(int pageNo,String t_No);
    ModelAndView listById(int pageNo,int t_id);
    ModelAndView listBySubject(int pageNo,int Subject);
    ModelAndView delete(int t_id,int pageNo);

}
