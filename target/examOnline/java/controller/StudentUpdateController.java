package controller;

import biz.StuManBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/teacher")
@org.springframework.stereotype.Controller
public class StudentUpdateController {
    @Autowired
    private StuManBiz stuManBiz;

    @RequestMapping(value = "/UpdStudentByAll")
    public void UpdStudentByAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        int pageNo = Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        int StuId = Integer.parseInt(httpServletRequest.getParameter("StuId"));
        String StuNo = httpServletRequest.getParameter("StuNo");
        String StuName = httpServletRequest.getParameter("StuName");
        int c_id = Integer.parseInt(httpServletRequest.getParameter("sclass"));
        String ByAll = httpServletRequest.getParameter("ByAll");//判断是否有值，有值则是从通过查询所有页面跳转过来的
        Map map = new HashMap();
        stuManBiz.UpdStuByName(StuId, StuNo, StuName, c_id, pageNo);
        if (ByAll != null) {
            map.put("sclass", c_id);
            map.put("ByAll", ByAll);
            httpServletRequest.getRequestDispatcher("/teacher/SelAllStu").forward(httpServletRequest, httpServletResponse);
        }
    }

    @RequestMapping(value = "/UpdStudentByName")
    // @Override
    public /*ModelAndView*/ void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        int pageNo = Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        int StuId = Integer.parseInt(httpServletRequest.getParameter("StuId"));
        String StuNo = httpServletRequest.getParameter("StuNo");
        String StuName = httpServletRequest.getParameter("StuName");
        int c_id = Integer.parseInt(httpServletRequest.getParameter("sclass"));
        String studentName = httpServletRequest.getParameter("studentName");//判断是否有值，有值则是从通过ByName查询页面跳转过来的
        Map map = new HashMap();
        stuManBiz.UpdStuByName(StuId, StuNo, StuName, c_id, pageNo);
        if (studentName != null) {
            map.put("studentName", studentName);
            map.put("pageNo",pageNo);
            httpServletRequest.getRequestDispatcher("/teacher/ByNameCon").forward(httpServletRequest, httpServletResponse);
        }
    }


    @RequestMapping(value = "/UpdStudentByClass")
    public void UpdStudentByClass(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        int pageNo = Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        int StuId = Integer.parseInt(httpServletRequest.getParameter("StuId"));
        String StuNo = httpServletRequest.getParameter("StuNo");
        String StuName = httpServletRequest.getParameter("StuName");
        int c_id = Integer.parseInt(httpServletRequest.getParameter("sclass"));
        String ByClass = httpServletRequest.getParameter("ByClass");//判断是否有值，有值则是从通过ByClass查询页面跳转过来的
        Map map = new HashMap();
        stuManBiz.UpdStuByName(StuId, StuNo, StuName, c_id, pageNo);
        if (ByClass != null) {
            map.put("sclass", c_id);
            map.put("ByClass", ByClass);
            map.put("pageNo",pageNo);
            httpServletRequest.getRequestDispatcher("/teacher/ByClassCon").forward(httpServletRequest, httpServletResponse);
        }
    }

    @RequestMapping(value = "/UpdStudentById")
    public void UpdStudentById(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        int pageNo = Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        int StuId = Integer.parseInt(httpServletRequest.getParameter("StuId"));
        String StuNo = httpServletRequest.getParameter("StuNo");
        String StuName = httpServletRequest.getParameter("StuName");
        int c_id = Integer.parseInt(httpServletRequest.getParameter("sclass"));
        String ById = httpServletRequest.getParameter("ById");//判断是否有值，有值则是从通过ByClass查询页面跳转过来的
        Map map = new HashMap();
        stuManBiz.UpdStuByName(StuId, StuNo, StuName, c_id, pageNo);
        if (ById != null) {
           // map.put("studentID",StuId);
            map.put("ById", ById);
            httpServletRequest.setAttribute("StuNo",StuNo);
            httpServletRequest.getRequestDispatcher("/teacher/ByIdCon").forward(httpServletRequest, httpServletResponse);
        }
    }

    //在查询所有学生界面删除学生
    @RequestMapping(value = "/DelStudentByAll")
    public void DelStudentByAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        int StuId = Integer.parseInt(request.getParameter("StuId"));
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        String ByAll = request.getParameter("ByAll");//判断是否有值，有值则是从通过Class查询页面跳转过来的
        Map map = new HashMap();
        stuManBiz.DelStu(StuId);
        request.setAttribute("pageNo", pageNo);
        if (ByAll != null) {
            map.put("ByAll", ByAll);
            request.getRequestDispatcher("/teacher/SelAllStu").forward(request, response);
        }
    }

    //在查询所有学生界面删除学生
    @RequestMapping(value = "/DelStudentByName")
    public void DelStudentByName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        int StuId = Integer.parseInt(request.getParameter("StuId"));
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        String studentName = request.getParameter("studentName");//判断是否有值，有值则是从通过姓名查询页面跳转过来的
        Map map = new HashMap();
        stuManBiz.DelStu(StuId);
        request.setAttribute("pageNo", pageNo);
        if (studentName != null) {
            map.put("studentName", studentName);
            request.getRequestDispatcher("/teacher/ByNameCon").forward(request, response);
        }
    }

    //在查询所有学生界面删除学生
    @RequestMapping(value = "/DelStudentByClass")
    public void DelStudentByClass(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        int StuId = Integer.parseInt(request.getParameter("StuId"));
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        String ByClass = request.getParameter("ByClass");//判断是否有值，有值则是从通过姓名查询页面跳转过来的
        Map map = new HashMap();
        stuManBiz.DelStu(StuId);
        request.setAttribute("pageNo", pageNo);
        if (ByClass != null) {
            map.put("studentName", ByClass);
            request.getRequestDispatcher("/teacher/ByClassCon").forward(request, response);
        }
    }
}
