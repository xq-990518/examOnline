package controller;

import biz.QueManBiz;
import entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@org.springframework.stereotype.Controller
public class SelQueShowSubController implements Controller {
    @Autowired
    private QueManBiz queManBiz;

    @RequestMapping(value = "/SelQueShowSub")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        ModelAndView modelAndView=null;
        Map map=new HashMap();
        //获取学科在下拉框中显示
        List<Subject> SubList = queManBiz.SubList();
        map.put("SubList",SubList);
        modelAndView=new ModelAndView("teacher/subjectQuery",map);
        return modelAndView;
    }
}
