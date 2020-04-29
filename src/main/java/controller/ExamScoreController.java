package controller;

import biz.QueManBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;


@org.springframework.stereotype.Controller
public class ExamScoreController implements Controller {
    @Autowired
    private QueManBiz queManBiz;

    @RequestMapping(value = "/examSource")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String q_list=httpServletRequest.getParameter("list");
        String answer=httpServletRequest.getParameter("answerList");
        String id=httpServletRequest.getParameter("exam_id");
        String student_id=httpServletRequest.getParameter("s_id");
        int exam_id=0;
        int s_id=0;
        if (id!="" && student_id!=""){
            exam_id=Integer.parseInt(id);
            s_id=Integer.parseInt(student_id);
        }
        List<String> list= Arrays.asList(q_list.split(","));
        List<String> answerList= Arrays.asList(answer.split(","));
        ModelAndView modelAndView=queManBiz.getSource(s_id,exam_id,list,answerList);
        return modelAndView;
    }
}
