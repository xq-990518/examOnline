package controller;

import biz.StuManBiz;
import entity.Page;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping(value = "/teacher")
@org.springframework.stereotype.Controller
public class ByClassController implements Controller {
    @Autowired
    private StuManBiz stuManBiz;

    @RequestMapping(value = "/ByClassCon")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        ModelAndView modelAndView = null;
        int pageNo= Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        int ClaId = Integer.parseInt(httpServletRequest.getParameter("sclass"));
        String ByClass=httpServletRequest.getParameter("ByClass");
        modelAndView=stuManBiz.StuByCla(ClaId,pageNo);
        return modelAndView;

    }
}
