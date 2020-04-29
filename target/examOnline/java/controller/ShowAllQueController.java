package controller;

import biz.QueManBiz;
import entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@org.springframework.stereotype.Controller
public class ShowAllQueController implements Controller {
    @Autowired
    private QueManBiz queManBiz;

    //显示所有试题
    @RequestMapping(value = "/ShowAllQue")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        Object object = httpServletRequest.getAttribute("pageNo");
        String no=null;
        if (object != null) {
        no= String.valueOf(object);
        }else {
            no = httpServletRequest.getParameter("pageNo");
        }
        int pageNo = 0;
        if (no != null) {
            pageNo = Integer.parseInt(no);
        }
        Page page = queManBiz.ShowAllQue(pageNo);
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("teacher/subjectManager", "page", page);
        return modelAndView;
    }

    //删除试题
    @RequestMapping(value = "/DelQuestion")
    public void DelQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        int QueId = Integer.parseInt(request.getParameter("QueId"));
        int pageNo= Integer.parseInt(request.getParameter("pageNo"));
        queManBiz.DelQuestion(QueId);
        request.setAttribute("pageNo",pageNo);
        request.getRequestDispatcher("/ShowAllQue").forward(request,response);
    }


}
