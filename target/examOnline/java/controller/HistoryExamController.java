package controller;

import biz.AchievementBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class HistoryExamController implements Controller {
    @Autowired
    private AchievementBiz achievementBiz;

    @RequestMapping(value = "/historyExam")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String id=httpServletRequest.getParameter("s_id");
        String no=httpServletRequest.getParameter("pageNo");
        int pageNo=0;
        ModelAndView modelAndView=null;
        int s_id=0;
        if (id!="" && no!=""){
            s_id=Integer.parseInt(id);
            pageNo=Integer.parseInt(no);
        }
        modelAndView=achievementBiz.getHistoryExam(s_id,pageNo);
        return modelAndView;
    }
}
