package controller;

import biz.QueManBiz;
import entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@org.springframework.stereotype.Controller
public class SelQueController implements Controller {
    @Autowired
    private QueManBiz queManBiz;

    @RequestMapping(value = "/SelQuestion")
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        String no=httpServletRequest.getParameter("pageNo");
        int SubId= Integer.parseInt(httpServletRequest.getParameter("subject_id"));
        int pageNo=0;
        if (no!=null){
            pageNo= Integer.parseInt(no);
        }else if (no!=""){
            pageNo= Integer.parseInt(no);
        }
        ModelAndView modelAndView=queManBiz.SelQuestion(SubId,pageNo);
        return modelAndView;
    }
}
