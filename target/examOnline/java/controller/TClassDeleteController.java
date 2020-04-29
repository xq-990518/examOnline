package controller;

import biz.TClassBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class TClassDeleteController implements Controller {
    @Autowired
    private TClassBiz tClassBiz;

    @RequestMapping(value = "/TClassDelete")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String cid=httpServletRequest.getParameter("c_id");
        String pageno=httpServletRequest.getParameter("pageNo");
        int c_id=0;
        int pageNo=0;
        if (cid!="" &&pageno!=""){
            c_id=Integer.parseInt(cid);
            pageNo= Integer.parseInt(pageno);
        }
        ModelAndView modelAndView=tClassBiz.Delete(c_id,pageNo);
        return modelAndView;
    }
}
