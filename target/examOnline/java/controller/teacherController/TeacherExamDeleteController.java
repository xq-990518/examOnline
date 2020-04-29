package controller.teacherController;

import biz.ExamBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class TeacherExamDeleteController implements Controller {
    @Autowired
    private ExamBiz examBiz;

    @RequestMapping(value = "/TeacherExamDelete")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String no=httpServletRequest.getParameter("pageNo");
        String exam_id=httpServletRequest.getParameter("e_id");
        String id=httpServletRequest.getParameter("s_id");
        int pageNo=0;
        int s_id=0;
        int e_id=0;
        if (no!="" && id!="" && exam_id!=""){
            e_id= Integer.parseInt(exam_id);
            pageNo= Integer.parseInt(no);
            s_id= Integer.parseInt(id);
        }
        ModelAndView modelAndView=examBiz.teacherExamDelete(e_id,s_id,pageNo);
        return modelAndView;
    }
}
