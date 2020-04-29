package controller;


import biz.TClassBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class TClassBeforeUpdateController implements Controller {
    @Autowired
    private TClassBiz tClassBiz;

    @RequestMapping(value = "/TClassBeforeUpdate")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String id=httpServletRequest.getParameter("c_id");
        int c_id=0;
        String no=httpServletRequest.getParameter("pageNo");
        int pageNo=0;
        if (id!="" && no!=""){
            c_id=Integer.parseInt(id);
            pageNo= Integer.parseInt(no);
        }
        ModelAndView modelAndView=tClassBiz.beforeUpdate(c_id,pageNo);
        return modelAndView;
    }
}
