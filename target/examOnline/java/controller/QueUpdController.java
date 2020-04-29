package controller;

import biz.QueManBiz;
import entity.Page;
import entity.Question;
import entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
public class QueUpdController implements Controller {
    @Autowired
    private QueManBiz queManBiz;

    //在修改界面显示信息
    @RequestMapping(value = "/ShowUpdInfo")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        Map map = new HashMap();
        int QueId = Integer.parseInt(httpServletRequest.getParameter("QueId"));
        int pageNo = Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        //获取学科在下拉框中显示
        List<Subject> SubList = queManBiz.SubList();
        Question question = queManBiz.getQue(QueId);
        ModelAndView modelAndView = null;
        map.put("SubList", SubList);
        map.put("question", question);
        map.put("pageNo", pageNo);
        modelAndView = new ModelAndView("/teacher/subjectUpdate", map);
        return modelAndView;
    }

    //修改过后返回查询所有界面
    @RequestMapping(value = "/UpdQuestion")
    public void DelQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int SubId = Integer.parseInt(request.getParameter("subject_id"));
        int QueId = Integer.parseInt(request.getParameter("QueId"));
        String QueName = request.getParameter("QueName");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");
        String resolution = request.getParameter("resolution");
        String[] str = request.getParameterValues("answer");
        int mark = Integer.parseInt(request.getParameter("mark"));
        String answer = "";
        for (int i = 0; i < str.length; i++) {
            answer += str[i];
        }
        queManBiz.UpdQue(QueId, QueName, optionA, optionB, optionC, optionD, answer, resolution, mark, SubId);
        request.setAttribute("pageNo", pageNo);
        request.getRequestDispatcher("/ShowAllQue").forward(request, response);
    }
}
