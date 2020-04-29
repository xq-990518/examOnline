package controller;

import biz.ExamBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class TeacherExamShowController implements Controller {
    @Autowired
    private ExamBiz examBiz;

    @RequestMapping(value = "/TeacherExamShow")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String no=httpServletRequest.getParameter("pageNo");
        int pageNo=0;
        if (no!=null){
            pageNo=Integer.parseInt(no);
        }
        ModelAndView modelAndView=examBiz.teacherExam(pageNo);
        return modelAndView;
    }
}
