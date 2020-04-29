package controller;

import biz.QueManBiz;
import entity.Page;
import entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/teacher")
@org.springframework.stereotype.Controller
public class QueAddController implements Controller {
    @Autowired
    private QueManBiz queManBiz;


    Page page=new Page();

    //添加试题中点击添加跳转到的的Controller
    @RequestMapping(value = "/AddQuestion")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        int SubId= Integer.parseInt(httpServletRequest.getParameter("Subject"));
        String QueName = httpServletRequest.getParameter("QueName");
        String optionA = httpServletRequest.getParameter("optionA");
        String optionB = httpServletRequest.getParameter("optionB");
        String optionC = httpServletRequest.getParameter("optionC");
        String optionD = httpServletRequest.getParameter("optionD");
        String resolution = httpServletRequest.getParameter("resolution");
        String[] str = httpServletRequest.getParameterValues("answer");
        String num = httpServletRequest.getParameter("mark");
        int mark=0;
        String answer = "";
        for (int i = 0; i < str.length; i++) {
            answer += str[i];
        }
        if (QueName!="" && optionA!="" &&optionB!=""&& optionC!=""&&optionD!="" && str.length>0&&num!=""){
            mark= Integer.parseInt(num);
            queManBiz.InsQue( QueName, optionA, optionB, optionC, optionD, answer, resolution, mark,SubId);
            modelAndView = new ModelAndView("teacher/subjectAdd");
        }else {
            map.put("tip","试题信息不可为空！        ");
            modelAndView=new ModelAndView("/teacher/subjectAdd",map);
        }
        return modelAndView;
    }

    //在试题添加界面中的下拉框显示出学科
    @RequestMapping(value = "/ShowAddQueSubject")
    public void ShowAddQueSubjectName(HttpServletRequest request,HttpServletResponse httpServletResponse) throws IOException {
        request.setCharacterEncoding("utf-8");
        ModelAndView modelAndView = null;
        //获取学科在下拉框中显示
        List<Subject> SubList = queManBiz.SubList();
        JsonController jsonController = new JsonController();
        String str = jsonController.getListJSON(SubList);
        jsonController.SendData(httpServletResponse, str);
    }

}
