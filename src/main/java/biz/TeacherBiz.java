package biz;

import entity.Teacher;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface TeacherBiz {
    List<Teacher> getTeacher();
    ModelAndView save(Teacher teacher,String tclass);
}
