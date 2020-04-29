package controller;


import biz.StuManBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/teacher")
@org.springframework.stereotype.Controller
public class StuAddController implements Controller {
    @Autowired
    private StuManBiz stuManBiz;

    @RequestMapping(value = "/AddStudent")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        ModelAndView modelAndView = null;
        String Stuid = httpServletRequest.getParameter("studentID");//学号：
        String StuName = httpServletRequest.getParameter("studentName");
        int StuCla = Integer.parseInt(httpServletRequest.getParameter("sclass"));
        boolean flag=stuManBiz.checkStudent(Stuid);
        Map map=new HashMap();
        String tip="";
        if (flag){
            stuManBiz.InsStu(Stuid,StuName,StuCla);
            tip="添加成功";
        }else {
            tip="已有此学生，请勿重复录入";
        }
        map.put("tip",tip);
        modelAndView = new ModelAndView("teacher/studentAdd",map);
        return modelAndView;
    }
}
