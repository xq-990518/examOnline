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
public class TeacherDelete implements Controller {
    @Autowired
    private TeacherBiz teacherBiz;

    @RequestMapping(value = "/teacherDelete")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String t_id = httpServletRequest.getParameter("tid");
        String no=httpServletRequest.getParameter("pageNo");
        int pageNo=0;
        if (no!=null){
            pageNo=Integer.parseInt(no);
        }
        ModelAndView modelAndView=teacherBiz.delete(Integer.parseInt(t_id),pageNo);
        return modelAndView;
    }
}
