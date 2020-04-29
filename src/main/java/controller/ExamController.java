package controller;


import biz.ExamBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class ExamController implements Controller {
    @Autowired
    private ExamBiz examBiz;

    @RequestMapping(value = "/startExam")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String id=httpServletRequest.getParameter("e_id");
        ModelAndView modelAndView=null;
        int e_id=0;
        if (id!=""){
            e_id=Integer.parseInt(id);
        }
        modelAndView=examBiz.getExam_Question(e_id);
        return modelAndView;
    }
}
