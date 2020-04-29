package controller.teacherController;

import biz.QueManBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class QuestionBeforeUpdateController implements Controller {
    @Autowired
    private QueManBiz queManBiz;

    @RequestMapping(value = "/QuestionBeforeUpdate")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        int q_id= Integer.parseInt(httpServletRequest.getParameter("QueId"));
        int pageNo= Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        ModelAndView modelAndView=queManBiz.teahcerBeforeUpdateQuestion(q_id,pageNo);
        return modelAndView;
    }
}
