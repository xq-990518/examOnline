package controller;

import biz.StuManBiz;
import entity.TClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ShowClassController {
    @Autowired
    private StuManBiz stuManBiz;

    //显示班级
    @RequestMapping(value = "/ShowClass")
    public void ShowSubName(HttpServletRequest request,HttpServletResponse response) throws Exception {
        JsonController jsonController=new JsonController();
        request.setCharacterEncoding("utf-8");
        List<TClass> ClassNameList=stuManBiz.ShowClass();
        String ClaName=jsonController.getListJSON(ClassNameList);
        jsonController.SendData(response,ClaName);
    }
}