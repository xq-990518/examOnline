package controller;

import biz.SubjectBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class SubjectBeforeUpdateController implements Controller {
    @Autowired
    private SubjectBiz subjectBiz;

    @RequestMapping(value = "/SubjectBeforeUpdate")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String no=httpServletRequest.getParameter("pageNo");
        String id=httpServletRequest.getParameter("subject_id");
        int pageNo=0;
        int subject_id=0;
        if (id!="" && no!=""){
            subject_id=Integer.parseInt(id);
            pageNo= Integer.parseInt(no);
        }
        ModelAndView modelAndView=subjectBiz.subjectBeforeUpdate(subject_id,pageNo);
        return modelAndView;
    }
}
