package controller.teacherController;

import biz.ExamBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class TeacherUpdateExamController implements Controller {
    @Autowired
    private ExamBiz examBiz;

    @RequestMapping(value = "/TeacherUpdateExam")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        String no=httpServletRequest.getParameter("pageNo");
        String exam_id=httpServletRequest.getParameter("e_id");
        String id=httpServletRequest.getParameter("s_id");
        String name=httpServletRequest.getParameter("e_name");
        String date=httpServletRequest.getParameter("date");
        int second=0;
        int pageNo=0;
        int s_id=0;
        int e_id=0;
        if (no!="" && date!="" && id!="" && exam_id!=""){
            e_id= Integer.parseInt(exam_id);
            pageNo= Integer.parseInt(no);
            second= Integer.parseInt(date);
            s_id= Integer.parseInt(id);
        }
        ModelAndView modelAndView=examBiz.teacherExamUpdate(e_id,pageNo,s_id,second,name);
        return modelAndView;
    }
}
