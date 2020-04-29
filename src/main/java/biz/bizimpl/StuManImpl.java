package biz.bizimpl;

import biz.StuManBiz;
import entity.*;
import help.PageTools;
import mapper.ExamMapper;
import mapper.StudentMapper;
import mapper.TClassMapper;
import mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuManImpl implements StuManBiz {
    @Autowired
    private TClassMapper tClassMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ExamMapper examMapper;
    PageTools pageTools = new PageTools();

    @Override
    public List ShowClass() {
        List<TClass> ShowClass = tClassMapper.ShowClass();
        return ShowClass;
    }

    @Override
    public void InsStu(String s_No, String s_Name, int c_id) {
        teacherMapper.AddStu(s_No, s_Name, c_id);

    }

    @Override
    public ModelAndView SelAllStu(int pageNo, String tip) {
        int num = teacherMapper.getStuCount();
        Page page = pageTools.getPage(num, pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<Student> SelAllStu = teacherMapper.SelAllStu(beginNo, page.getPageSize());
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        if (SelAllStu.size() > 0) {
            page.setTopicList(SelAllStu);
        }
        map.put("page", page);
        if (!tip.equals("")) {
            map.put("tip", tip);
        }
        modelAndView = new ModelAndView("teacher/studentManager", map);
        return modelAndView;
    }

    @Override
    public ModelAndView StuById(String StuNo,int pageNo) {
        Map map = new HashMap();
        ModelAndView modelAndView = null;
        int num = teacherMapper.byIdCount(StuNo);
        Page page = pageTools.getPage(num, 1);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<Student> StuById = teacherMapper.StuById(StuNo, beginNo, page.getPageSize());
        if (StuById.size() > 0) {
            page.setTopicList(StuById);
        }
        map.put("page", page);
        map.put("StuNo",StuNo);
        modelAndView = new ModelAndView("teacher/studentManagerByID", map);
        return modelAndView;
    }

    @Override
    public ModelAndView StuByCla(int ClaId,int pageNo) {
        Map map = new HashMap();
        ModelAndView modelAndView = null;
        int num = teacherMapper.byClaIdCount(ClaId);
        Page page = pageTools.getPage(num, pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<Student> StuByCla = teacherMapper.StuByCla(ClaId, beginNo, page.getPageSize());
        if (StuByCla.size() > 0) {
            page.setTopicList(StuByCla);
        }
        map.put("page", page);
        map.put("c_id", ClaId);
        modelAndView = new ModelAndView("teacher/studentManagerByClass", map);
        return modelAndView;
    }

    @Override
    public ModelAndView StuByName(String StuName, int pageNo) {
        int num = teacherMapper.byStuNameCount(StuName);
        Map map = new HashMap();
        Page page = pageTools.getPage(num, pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<Student> StuByName = teacherMapper.StuByName(StuName, beginNo, page.getPageSize());
        if (StuByName.size() > 0) {
            page.setTopicList(StuByName);
        }
        map.put("studentName", StuName);
        map.put("page", page);
        ModelAndView modelAndView = new ModelAndView("teacher/studentManagerByName", map);
        return modelAndView;
    }

    @Override
    public Student ShowStuInfo(int StuId) {
        Student ShowStuInfo = studentMapper.ShowStuInfo(StuId);
        return ShowStuInfo;
    }

    @Override
    public ModelAndView UpdStu(int StuId, String StuNo, String StuName, int ClaId,int pageNo) {
        String str=checkUpdateStudent(StuId,StuNo);
        studentMapper.UpdStu(StuId, StuNo, StuName, ClaId);
        ModelAndView modelAndView=SelAllStu(pageNo,str);
        return modelAndView;
    }

    @Override
    public boolean checkStudent(String s_no) {
        boolean flag = true;
        List<Student> students = studentMapper.checkStudent(s_no);
        if (students.size() > 0) {
            flag = false;
        }
        return flag;
    }

    @Override
    public String checkUpdateStudent(int StuId,String StuNo) {
        String str="";
        List<Student> students=studentMapper.checkStudent(StuNo);
        if (students.size()>0){
            int num=0;
            for (Student student:students
            ) {
                if (student.getS_No()==StuNo){
                   num++;
                }
            }
            if (num==1){
                str="yes";
            }else {
                str="no";
            }
        }else {
            str="ok";
        }
        return str;
    }

    @Override
    public void DelStu(int StuId) {
        studentMapper.DelStu(StuId);
    }

    @Override
    public void UpdStuByName(int StuId, String StuNo, String StuName, int ClaId, int pageNo) {
        studentMapper.UpdStu(StuId, StuNo, StuName, ClaId);
    }

    @Override
    public ModelAndView teacherSelectStudent(int t_id, int subject_id, int c_id, int pageNo) {
        Map map = new HashMap();
        ModelAndView modelAndView = null;
        int num = teacherMapper.byClaIdCount(c_id);
        Page page = pageTools.getPage(num, pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<Student> StuByCla = teacherMapper.StuByCla(c_id, beginNo, page.getPageSize());
        List<Exam> TeaIdSubIdGetEName = examMapper.TeaIdSubIdGetEName(t_id, subject_id);
        int Size=TeaIdSubIdGetEName.size() - 1;
        int LastExamID = TeaIdSubIdGetEName.get(Size).getE_id();

        if (StuByCla.size() > 0) {
            page.setTopicList(StuByCla);
        }
        map.put("page", page);
        map.put("c_id", c_id);
        map.put("TeaIdSubIdGetEName", TeaIdSubIdGetEName);
        List<Achievement> achievementList=TeaIdSubIdGetEName.get(Size).getAchievements();
        map.put("achievementList", achievementList);
        map.put("LastExamID", LastExamID);
        modelAndView = new ModelAndView("teachers/studentManagerByClass", map);
        return modelAndView;
    }
}
