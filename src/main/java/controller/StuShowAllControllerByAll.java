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
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/teacher")
@org.springframework.stereotype.Controller
public class StuShowAllControllerByAll implements Controller {
    @Autowired
    private StuManBiz stuManBiz;


    @RequestMapping(value = "/SelAllStu")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        ModelAndView modelAndView = null;
        int pageNo = 0;
        Object object = httpServletRequest.getAttribute("pageNo");
        String No = httpServletRequest.getParameter("pageNo");
        if (object != null) {
            pageNo = (int) object;
        } else {
            if (No != null) {
                pageNo = Integer.parseInt(No);
            }
        }
        modelAndView = stuManBiz.SelAllStu(pageNo,"");
        return modelAndView;
    }

}
