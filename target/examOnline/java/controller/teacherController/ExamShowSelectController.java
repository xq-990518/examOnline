package controller.teacherController;

import biz.ExamBiz;
import controller.JsonController;
import entity.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ExamShowSelectController {
    @Autowired
    private ExamBiz examBiz;

    @RequestMapping(value = "/ExamShowSelect")
    public void getExamShowSelect(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        int s_id= Integer.parseInt(request.getParameter("s_id"));
        List<Exam> list=examBiz.getExamSelect(s_id);
        JsonController jsonController=new JsonController();
        String str=jsonController.getListJSON(list);
        jsonController.SendData(response,str);
    }
}
