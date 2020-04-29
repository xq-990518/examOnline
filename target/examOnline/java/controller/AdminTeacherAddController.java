package controller;

import biz.TClassBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class AdminTeacherAddController implements Controller {
    @Autowired
    private TClassBiz tClassBiz;

    @RequestMapping(value = "/AdminTeacherAddBefore")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView=tClassBiz.adminTeacherBeforeAdd();
        return modelAndView;
    }
}
