package controller.teacherController;

import biz.ExamBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class TeacherAddExamController implements Controller {
    @Autowired
    private ExamBiz examBiz;

    @RequestMapping(value = "/teacherExamAdd")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        int s_id= Integer.parseInt(httpServletRequest.getParameter("s_id"));
        String exam_name=httpServletRequest.getParameter("exam_name");
        int examDate= Integer.parseInt(httpServletRequest.getParameter("examDate"));
        int exam_num= Integer.parseInt(httpServletRequest.getParameter("exam_num"));
        ModelAndView modelAndView=examBiz.teacherExamAdd(exam_name,s_id,examDate,exam_num);
        return modelAndView;
    }
}
