package controller.teacherController;

import biz.QueManBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/teachers")
@org.springframework.stereotype.Controller
public class QuestionAddController implements Controller {
    @Autowired
    private QueManBiz queManBiz;

    @RequestMapping(value = "/teacherQuestionAdd")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        int s_id= Integer.parseInt(httpServletRequest.getParameter("s_id"));
        String QueName = httpServletRequest.getParameter("QueName");
        String optionA = httpServletRequest.getParameter("optionA");
        String optionB = httpServletRequest.getParameter("optionB");
        String optionC = httpServletRequest.getParameter("optionC");
        String optionD = httpServletRequest.getParameter("optionD");
        String resolution = httpServletRequest.getParameter("resolution");
        String[] str = httpServletRequest.getParameterValues("answer");
        String num=httpServletRequest.getParameter("mark");
        String answer = "";
        int mark = 0;
        for (int i = 0; i < str.length; i++) {
            answer += str[i];
        }
        ModelAndView modelAndView=null;
        Map map=new HashMap();
        if (QueName!="" && optionA!="" &&optionB!=""&& optionC!=""&&optionD!="" && str.length>0&&num!=""){
            mark= Integer.parseInt(num);
            modelAndView=queManBiz.teacherInsertQuestion(QueName,optionA,optionB,optionC,optionD,answer,resolution,mark,s_id);
        }else {
            map.put("tip","试题信息不可为空！        ");
            modelAndView=new ModelAndView("/teachers/subjectAdd",map);
        }
        return modelAndView;
    }
}
