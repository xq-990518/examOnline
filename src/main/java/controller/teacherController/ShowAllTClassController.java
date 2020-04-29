package controller.teacherController;

import biz.TClassBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class ShowAllTClassController implements Controller {
    @Autowired
    private TClassBiz tClassBiz;

    @RequestMapping(value = "/showAllTClass")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        int pageNo= Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        int t_id= Integer.parseInt(httpServletRequest.getParameter("t_id"));
        ModelAndView modelAndView=tClassBiz.teacherQueryTClass(t_id,pageNo);
        return modelAndView;
    }
}
