package controller.teacherController;

import biz.StuManBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class ShowAllStudentController implements Controller {
    @Autowired
    private StuManBiz stuManBiz;

    @RequestMapping(value = "/ShowAllStudentByClass")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        int pageNo = Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        int c_id = Integer.parseInt(httpServletRequest.getParameter("c_id"));
        int subject_id = Integer.parseInt(httpServletRequest.getParameter("subject_id"));
        int t_id = Integer.parseInt(httpServletRequest.getParameter("t_id"));
        ModelAndView modelAndView = stuManBiz.teacherSelectStudent(t_id, subject_id, c_id, pageNo);
        return modelAndView;
    }
}
