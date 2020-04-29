package controller;

import biz.ExamBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class ExamUpdateController implements Controller {
    @Autowired
    private ExamBiz examBiz;

    @RequestMapping(value = "/ExamUpdate")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        String no=httpServletRequest.getParameter("pageNo");
        String exam_id=httpServletRequest.getParameter("e_id");
        String name=httpServletRequest.getParameter("e_name");
        String date=httpServletRequest.getParameter("date");
        int pageNo=0;
        int second=0;
        int e_id=0;
        if (no!="" && date!="" && exam_id!=""){
            e_id= Integer.parseInt(exam_id);
            pageNo= Integer.parseInt(no);
            second= Integer.parseInt(date);
        }
        ModelAndView modelAndView=examBiz.examUpdate(e_id,pageNo,second,name);
        return modelAndView;
    }
}
