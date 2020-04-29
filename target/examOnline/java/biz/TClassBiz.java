package biz;


import entity.TClass;
import org.springframework.web.servlet.ModelAndView;

public interface TClassBiz {
    ModelAndView insertTClass(String c_name);
    ModelAndView getTClas(int pageNo);
    ModelAndView beforeUpdate(int c_id, int pageNo);
    ModelAndView Update(TClass tClass, int pageNo);
    ModelAndView Delete(int c_id, int pageNo);
    boolean checkTClass(String c_name);

    ModelAndView teacherQueryTClass(int t_id,int pageNo);
    ModelAndView adminTeacherBeforeAdd();
}
