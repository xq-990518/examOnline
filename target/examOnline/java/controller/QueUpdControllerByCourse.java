package controller;

import biz.QueManBiz;
import entity.Question;
import entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@org.springframework.stereotype.Controller
public class QueUpdControllerByCourse implements Controller {
    @Autowired
    private QueManBiz queManBiz;

    //在修改界面显示信息
    @RequestMapping(value = "/ShowUpdInfoByCourse")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        int QueId = Integer.parseInt(httpServletRequest.getParameter("QueId"));
        int pageNo = Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        //接收通过查询学科界面传过来的值判断是否从查询所有界面跳转到此界面的
        int subject_id = 0;
        String StrSub_id = httpServletRequest.getParameter("subject_id");
        if (StrSub_id != null) {
            subject_id = Integer.parseInt(StrSub_id);
        }
        //获取学科在下拉框中显示
        List<Subject> SubList = queManBiz.SubList();
        Question question = queManBiz.getQue(QueId);
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        map.put("SubList", SubList);
        map.put("question", question);
        map.put("pageNo", pageNo);
        map.put("subject_id", subject_id);
        modelAndView = new ModelAndView("teacher/subjectUpdateByCourse", map);

        return modelAndView;
    }

    @RequestMapping(value = "/QuestionByCourseUpdate")
    public void getQuestion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        int pageNo = Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        int SubId= Integer.parseInt(httpServletRequest.getParameter("subject_id"));
        int QueId = Integer.parseInt(httpServletRequest.getParameter("QueId"));
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
        queManBiz.UpdQue(QueId, QueName, optionA, optionB, optionC, optionD, answer, resolution, mark,SubId);
        httpServletRequest.setAttribute("pageNo", pageNo);
        httpServletRequest.getRequestDispatcher("/SelQuestion").forward(httpServletRequest, httpServletResponse);
    }

}
