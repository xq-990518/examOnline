package controller;

import biz.TClassBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/teacher")
@org.springframework.stereotype.Controller
public class TClassAddController implements Controller {
    @Autowired
    private TClassBiz tClassBiz;

    @RequestMapping(value = "/t_class_add")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String c_name=httpServletRequest.getParameter("c_name");
        ModelAndView modelAndView=tClassBiz.insertTClass(c_name);
        return modelAndView;
    }
}
