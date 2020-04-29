package controller;

import biz.SubjectBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@org.springframework.stereotype.Controller
@RequestMapping(value = "/teacher")
public class TeacherAddController implements Controller {
    @Autowired
    private SubjectBiz subjectBiz;

    @RequestMapping(value = "/TeacherAdd")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String c_name=httpServletRequest.getParameter("c_name");
        String id=httpServletRequest.getParameter("sclass");
        int t_id=0;
        if (id!=""){
            t_id= Integer.parseInt(id);
        }
        ModelAndView modelAndView=subjectBiz.subjectAdd(t_id,c_name);
        return modelAndView;
    }
}
