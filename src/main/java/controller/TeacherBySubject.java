package controller;

import biz.TeacherBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/teacher")
@org.springframework.stereotype.Controller
public class TeacherBySubject implements Controller {
    @Autowired
    private TeacherBiz teacherBiz;

    @RequestMapping(value = "/getTeacherBySubject")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String no=httpServletRequest.getParameter("pageNo");
        String name=httpServletRequest.getParameter("subject");
        int pageNo=0;
        if (no!=null){
            pageNo=Integer.parseInt(no);
        }
        ModelAndView modelAndView = teacherBiz.listBySubject(pageNo,Integer.parseInt(name));
        return modelAndView;
    }
}
