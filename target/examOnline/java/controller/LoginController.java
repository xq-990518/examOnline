package controller;

import biz.LoginBiz;
import entity.Administor;
import entity.Student;
import entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class LoginController implements Controller {
    @Autowired
    private LoginBiz loginBiz;

    @RequestMapping(value = "/login")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String username=httpServletRequest.getParameter("username");
        String password=httpServletRequest.getParameter("password");
        String role=httpServletRequest.getParameter("role");
        HttpSession session=httpServletRequest.getSession();
        ModelAndView modelAndView=null;
        if (role.equals("student")){
            Student student=loginBiz.getSLog(username);
            if (student!=null){
                session.setAttribute("student",student);
                modelAndView=new ModelAndView("student/myInfo");
            }else {
                modelAndView=new ModelAndView("/login");
            }
        }else if (role.equals("teacher")){
            Teacher teacher=loginBiz.getTLog(username,password);
            if (teacher!=null){
                session.setAttribute("teacher",teacher);
                modelAndView=new ModelAndView("teachers/teacher");
            }else {
                modelAndView=new ModelAndView("/login");
            }
        }else if (role.equals("admin")){
            Administor administor=loginBiz.getALog(username,password);
            if (administor!=null){
                session.setAttribute("admin",administor);
                modelAndView=new ModelAndView("teacher/teacher");
            }else {
                modelAndView=new ModelAndView("/login");
            }
        }
        return modelAndView;
    }
}
