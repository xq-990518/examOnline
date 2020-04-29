package controller;

import biz.StuManBiz;
import entity.Student;
import entity.TClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping(value = "/teacher")
@org.springframework.stereotype.Controller
public class StudentShowController implements Controller {
    @Autowired
    private StuManBiz stuManBiz;

    //在修改学生界面显示默认值
    @RequestMapping(value = "/ShowStuInfo")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        int StuId = Integer.parseInt(httpServletRequest.getParameter("StuId"));
        int pageNo = Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        String ByAll = httpServletRequest.getParameter("ByAll");
        //获取班级在下拉框中显示
        List<TClass> ClaList = stuManBiz.ShowClass();
        //接收点击到的信息
        Student ShowStuInfo = stuManBiz.ShowStuInfo(StuId);
        if (ByAll != null) {
            map.put("ByAll",ByAll);
        }
        map.put("ClaList", ClaList);
        map.put("ShowStuInfo", ShowStuInfo);
        map.put("pageNo", pageNo);
        modelAndView = new ModelAndView("/teacher/studentUpdate", map);

        return modelAndView;
    }


}
