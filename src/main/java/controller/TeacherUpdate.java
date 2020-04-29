package controller;

import biz.TeacherBiz;
import entity.Subject;
import entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/teacher")
@org.springframework.stereotype.Controller
public class TeacherUpdate implements Controller {
    @Autowired
    private TeacherBiz teacherBiz;

    @RequestMapping(value = "/updateTeacher")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String no = httpServletRequest.getParameter("pageNo");
        String t_name = httpServletRequest.getParameter("t_Name");
        String t_No = httpServletRequest.getParameter("t_No");
        String id = httpServletRequest.getParameter("t_id");
        String subject = httpServletRequest.getParameter("subject");
        String tclass = httpServletRequest.getParameter("tclass");
        String t_password = httpServletRequest.getParameter("t_password");
        Subject subject1 = new Subject(Integer.parseInt(subject));
        Teacher teacher = new Teacher(Integer.parseInt(id), t_No, t_name, t_password, subject1);
        int pageNo=0;
        if (no!=null){
            pageNo=Integer.parseInt(no);
        }
        ModelAndView modelAndView = teacherBiz.update(pageNo,teacher,tclass);
        return modelAndView;
    }
}
