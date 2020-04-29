package controller;

import biz.AchievementBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class HistoryDeleteController implements Controller {
    @Autowired
    private AchievementBiz achievementBiz;

    @RequestMapping(value = "/historyDelete")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String id=httpServletRequest.getParameter("a_id");
        String no=httpServletRequest.getParameter("pageNo");
        String sid=httpServletRequest.getParameter("s_id");
        int a_id=0;
        int pageNo=0;
        int s_id=0;
        if (id!="" && no!="" && sid!=""){
            a_id=Integer.parseInt(id);
            pageNo=Integer.parseInt(no);
            s_id=Integer.parseInt(sid);
        }
        achievementBiz.deleteHistory(a_id);
        ModelAndView modelAndView=achievementBiz.getHistoryExam(s_id,pageNo);
        return modelAndView;
    }
}
