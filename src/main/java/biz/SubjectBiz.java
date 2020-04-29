package biz;

import org.springframework.web.servlet.ModelAndView;

public interface SubjectBiz {
    ModelAndView subjectAdd(int t_id, String c_name);
    ModelAndView subjectQuery(int pageNo);
    ModelAndView subjectBeforeUpdate(int subject_id, int pageNo);
    ModelAndView subjectUpdate(int subject_id, String subject_name, int pageNo);
    ModelAndView subjectdelete(int subject_id, int pageNo);
    String checkSubject(String c_name,int t_id);
}
