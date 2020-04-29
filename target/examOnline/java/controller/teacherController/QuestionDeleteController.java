package controller.teacherController;

import biz.QueManBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class QuestionDeleteController implements Controller {
    @Autowired
    private QueManBiz queManBiz;

    @RequestMapping(value = "/QuestionDelete")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        int pageNo= Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        int s_id= Integer.parseInt(httpServletRequest.getParameter("s_id"));
        int q_id= Integer.parseInt(httpServletRequest.getParameter("QueId"));
        ModelAndView modelAndView=queManBiz.teacherDeleteQuestion(q_id,s_id,pageNo);
        return modelAndView;
    }
}
