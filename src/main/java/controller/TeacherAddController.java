package controller;

import biz.SubjectBiz;
import biz.TeacherBiz;
import entity.Subject;
import entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private TeacherBiz teacherBiz;

    @RequestMapping(value = "/TeacherAdd")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String c_name = httpServletRequest.getParameter("c_name");
        String id = httpServletRequest.getParameter("sclass");
        int t_id = 0;
        if (id != "") {
            t_id = Integer.parseInt(id);
        }
        ModelAndView modelAndView = subjectBiz.subjectAdd(t_id, c_name);
        return modelAndView;
    }

    @PostMapping(value = "/addTeacher")
    public ModelAndView save(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String t_name = httpServletRequest.getParameter("t_Name");
        String t_No = httpServletRequest.getParameter("t_No");
        String subject = httpServletRequest.getParameter("subject");
        String tclass = httpServletRequest.getParameter("tclass");
        String t_password = httpServletRequest.getParameter("t_password");
        Subject subject1 = new Subject(Integer.parseInt(subject));
        Teacher teacher = new Teacher(0, t_No, t_name, t_password, subject1);
        // todo
        ModelAndView modelAndView = teacherBiz.save(teacher,tclass);
        return modelAndView;
    }


}
