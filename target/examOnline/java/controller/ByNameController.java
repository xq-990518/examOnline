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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "teacher")
@org.springframework.stereotype.Controller
public class ByNameController implements Controller {
    @Autowired
    private StuManBiz stuManBiz;

    @RequestMapping(value = "/ByNameCon")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        ModelAndView modelAndView = null;
        String StuName = httpServletRequest.getParameter("studentName");
        String No= httpServletRequest.getParameter("pageNo");
        int pageNo=0;
        if (No!=null){
            pageNo= Integer.parseInt(No);
        }else if (No!=""){
            pageNo= Integer.parseInt(No);
        }
       modelAndView=stuManBiz.StuByName(StuName,pageNo);
        return modelAndView;

    }

}
