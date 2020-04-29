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
public class ByIdController implements Controller {
    @Autowired
    private StuManBiz stuManBiz;

    @RequestMapping(value = "/ByIdCon")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        ModelAndView modelAndView = null;
        Object object = httpServletRequest.getAttribute("StuNo");//学号
        String StuNo =null;
        String No= httpServletRequest.getParameter("StuNo");//学号
        if (object!=null){
            StuNo=object.toString();
        }else if (No!=""){
            StuNo=No;
        }
        int pageNo = Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        String ById = httpServletRequest.getParameter("ById");
        modelAndView = stuManBiz.StuById(StuNo, pageNo);
        return modelAndView;

    }
}
