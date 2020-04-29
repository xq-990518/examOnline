package controller;

import biz.TClassBiz;
import entity.TClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class TClassUpdateController implements Controller {
    @Autowired
    private TClassBiz tClassBiz;

    @RequestMapping(value = "/TClassUpdate")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String id=httpServletRequest.getParameter("c_id");
        String no=httpServletRequest.getParameter("pageNo");
        int pageNo=0;
        int c_id=0;
        if (id!="" && no!=""){
            c_id=Integer.parseInt(id);
            pageNo= Integer.parseInt(no);
        }
        String c_name=httpServletRequest.getParameter("c_name");
        ModelAndView modelAndView=tClassBiz.Update(new TClass(c_id,c_name),pageNo);
        return modelAndView;
    }
}
