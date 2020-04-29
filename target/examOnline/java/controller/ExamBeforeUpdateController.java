package controller;

import biz.ExamBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class ExamBeforeUpdateController implements Controller {
    @Autowired
    private ExamBiz examBiz;

    @RequestMapping(value = "/ExamBeforeUpdate")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        String id=httpServletRequest.getParameter("e_id");
        String no=httpServletRequest.getParameter("pageNo");
        int e_id=0;
        int pageNo=0;
        if (id!="" && no!=""){
            e_id= Integer.parseInt(id);
            pageNo= Integer.parseInt(no);
        }
        ModelAndView modelAndView=examBiz.examBeforeUpdate(e_id,pageNo);
        return modelAndView;
    }
}
