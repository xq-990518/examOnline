package controller;

import biz.SubjectBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class SubjectQueryController implements Controller {
    @Autowired
    private SubjectBiz subjectBiz;

    @RequestMapping(value = "/SubjectQuery")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String no=httpServletRequest.getParameter("pageNo");
        int pageNo=0;
        if (no!=""){
            pageNo=Integer.parseInt(no);
        }
        ModelAndView modelAndView=subjectBiz.subjectQuery(pageNo);
        return modelAndView;
    }
}
