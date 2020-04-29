package controller;

import biz.ExamBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/teacher")
@org.springframework.stereotype.Controller
public class ExamAddController implements Controller {
    @Autowired
    private ExamBiz examBiz;

    @RequestMapping(value = "/createExam")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String exam_name=httpServletRequest.getParameter("exam_name");
        String subject=httpServletRequest.getParameter("subject");
        String time=httpServletRequest.getParameter("examDate");
        String num=httpServletRequest.getParameter("exam_num");
        int subject_id=0;
        int examDate=0;
        int exam_num=0;
        if (time!="" && num!="" && subject!=""){
            examDate= Integer.parseInt(time);
            exam_num= Integer.parseInt(num);
            subject_id= Integer.parseInt(subject);
        }
        ModelAndView modelAndView=examBiz.ExamAdd(exam_name,subject_id,examDate,exam_num);
        return modelAndView;
    }
}
