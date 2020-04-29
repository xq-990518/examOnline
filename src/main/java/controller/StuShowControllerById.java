package controller;

import biz.StuManBiz;
import entity.Student;
import entity.TClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/teacher")
@org.springframework.stereotype.Controller
public class StuShowControllerById implements Controller {
    @Autowired
    private StuManBiz stuManBiz;

    @RequestMapping(value = "/ShowStuInfoById")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        int StuId = Integer.parseInt(httpServletRequest.getParameter("StuId"));
        int pageNo = Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        String ById=httpServletRequest.getParameter("ById");//判断是否从ByID界面跳转过来的
        //获取班级在下拉框中显示
        List<TClass> ClaList = stuManBiz.ShowClass();
        //接收点击到的信息
        Student ShowStuInfo = stuManBiz.ShowStuInfo(StuId);
        if (ById!=null){
            map.put("ById",ById);
        }
        map.put("ClaList", ClaList);
        map.put("ShowStuInfo", ShowStuInfo);
        map.put("pageNo", pageNo);
        modelAndView = new ModelAndView("/teacher/studentUpdateByID", map);
        return modelAndView;

    }
}
