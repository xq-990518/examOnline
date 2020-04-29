package controller.teacherController;

import biz.QueManBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class QuestionUpdateController implements Controller {
    @Autowired
    private QueManBiz queManBiz;

    @RequestMapping(value ="/QuestionUpdate")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        int pageNo= Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        int s_id= Integer.parseInt(httpServletRequest.getParameter("s_id"));
        int q_id= Integer.parseInt(httpServletRequest.getParameter("QueId"));
        String QueName = httpServletRequest.getParameter("QueName");
        String optionA = httpServletRequest.getParameter("optionA");
        String optionB = httpServletRequest.getParameter("optionB");
        String optionC = httpServletRequest.getParameter("optionC");
        String optionD = httpServletRequest.getParameter("optionD");
        String resolution = httpServletRequest.getParameter("resolution");
        String[] str = httpServletRequest.getParameterValues("answer");
        int mark = Integer.parseInt(httpServletRequest.getParameter("mark"));
        String answer = "";
        for (int i = 0; i < str.length; i++) {
            answer += str[i];
        }
        ModelAndView modelAndView=queManBiz.teacherUpdateQuestion(QueName,optionA,optionB,optionC,optionD,answer,resolution,mark,s_id,q_id,pageNo);
        return modelAndView;
    }
}
