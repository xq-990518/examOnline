package controller.teacherController;

import biz.ExamBiz;
import entity.Achievement;
import entity.Exam;
import entity.Page;
import entity.Student;
import help.PageTools;
import mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequestMapping(value = "/teachers")
@org.springframework.stereotype.Controller
public class ShowMarkOrderController implements Controller {
    @Autowired
    private ExamBiz examBiz;
    @Autowired
    private TeacherMapper teacherMapper;

    @RequestMapping(value = "/ShowMarkOrderCon")

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setCharacterEncoding("utf-8");
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        int c_id = Integer.parseInt(httpServletRequest.getParameter("c_id"));
        int e_id = Integer.parseInt(httpServletRequest.getParameter("e_id"));
        int pageNo = Integer.parseInt(httpServletRequest.getParameter("pageNo"));
        //获取考试信息
        List<Achievement> ShowMarkByExam = examBiz.ShowMarkByExam(e_id);

        //获取学生信息
        PageTools pageTools = new PageTools();
        int num = teacherMapper.CountStuByClaOrderBy(c_id,e_id);
        Page page = pageTools.getPage(num, pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<Student> StuByCla = teacherMapper.StuByClaOrderBy(c_id, beginNo, page.getPageSize(),e_id);
        if (StuByCla.size() > 0) {
            page.setTopicList(StuByCla);
        }
        Exam ExamName=examBiz.GetExamName(e_id);
        map.put("ExamName",ExamName);
        map.put("page", page);
        map.put("e_id", e_id);
        map.put("c_id", c_id);
        map.put("ShowMarkByExam", ShowMarkByExam);
        modelAndView = new ModelAndView("teachers/ShowExamOrder", map);
        return modelAndView;
    }

}
