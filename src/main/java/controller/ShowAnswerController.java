package controller;


import biz.ExamBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class ShowAnswerController implements Controller {
    @Autowired
    private ExamBiz examBiz;

    @RequestMapping(value = "/showAnswer")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String id=httpServletRequest.getParameter("e_id");
        int e_id=0;
        if (id!=""){
            e_id=Integer.parseInt(id);
        }
        ModelAndView modelAndView=examBiz.showExamQuestion(e_id);
        return modelAndView;
    }
}
