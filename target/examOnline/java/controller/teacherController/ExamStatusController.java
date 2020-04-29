package controller.teacherController;

import biz.ExamBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class ExamStatusController implements Controller {
    @Autowired
    private ExamBiz examBiz;

    @RequestMapping(value = "/ExamStatus")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        int e_id= Integer.parseInt(httpServletRequest.getParameter("e_id"));
        int pageNO= Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        int e_type= Integer.parseInt(httpServletRequest.getParameter("e_type"));
        int s_id= Integer.parseInt(httpServletRequest.getParameter("s_id"));
        ModelAndView modelAndView=examBiz.examStatus(e_id,pageNO,e_type,s_id);
        return modelAndView;
    }
}
