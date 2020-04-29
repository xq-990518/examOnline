package controller;

import biz.TeacherBiz;
import entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class OnloadTeacherController {
    @Autowired
    private TeacherBiz teacherBiz;

    @RequestMapping(value = "/OnloadTeacher")

    public void getOnload(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        List<Teacher> list=teacherBiz.getTeacher();
        JsonController jsonController=new JsonController();
        String teachers=jsonController.getListJSON(list);
        jsonController.SendData(httpServletResponse,teachers);
    }
}
