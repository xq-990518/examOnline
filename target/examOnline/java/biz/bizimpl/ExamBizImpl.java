package biz.bizimpl;

import biz.ExamBiz;
import entity.*;
import help.PageTools;
import mapper.AchievementMapper;
import mapper.ExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExamBizImpl implements ExamBiz {

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private AchievementMapper achievementMapper;

    PageTools pageTools=new PageTools();

    @Override
    public ModelAndView getExam(int s_id,int pageNo) {
        int num = examMapper.getExamCount();
        Page page=pageTools.getPage(num,pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<Exam> list = examMapper.getStudentExam(beginNo, page.getPageSize());
        List<Achievement> achievements=achievementMapper.getExamShow(s_id);
        Map map = new HashMap();
        ModelAndView modelAndView = null;
        if (list.size() > 0) {
            page.setTopicList(list);
            map.put("page", page);
            map.put("checkStudent",achievements);
            modelAndView = new ModelAndView("student/showExam", map);
        }else {
            modelAndView = new ModelAndView("student/showExam");
        }
        return modelAndView;
    }

    @Override
    public ModelAndView getExam_Question(int e_id) {
        Exam exam = examMapper.getQues(e_id);
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        if (exam != null) {
            map.put("exam", exam);
            map.put("exam_id",e_id);
            modelAndView = new ModelAndView("student/index", map);
        }
        return modelAndView;
    }

    @Override
    public ModelAndView showExamQuestion(int e_id) {
        Exam exam = examMapper.getQues(e_id);
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        if (exam != null) {
            int exam_score=0;
            List<Question> list=exam.getQuestions();
            for (Question question:list
                 ) {
                exam_score+=question.getMark();
            }
            map.put("exam", exam);
            map.put("exam_score",exam_score);
            modelAndView = new ModelAndView("student/showAnswer", map);
        }
        return modelAndView;
    }

    @Override
    public ModelAndView ExamAdd(String exam_name, int subject, int examDate, int exam_num) {
        Map map=new HashMap();
        ModelAndView modelAndView=null;
        String tip=examAdd(exam_name,subject,examDate,exam_num);
        map.put("tip",tip);
        modelAndView=new ModelAndView("teacher/ExamAdd",map);
        return modelAndView;
    }

    //修改前查询
    @Override
    public ModelAndView examBeforeUpdate(int e_id,int pageNo) {
        ModelAndView modelAndView = null;
        Map map=teacherExamUpdateBefore(e_id,pageNo);
        modelAndView = new ModelAndView("teacher/ExamUpdate", map);
        return modelAndView;
    }


    //修改
    @Override
    public ModelAndView examUpdate(int e_id, int pageNo,int second,String name) {
        ModelAndView modelAndView=null;
        try {
            examMapper.teacherUpdateExam(e_id,second,name);
            modelAndView=teacherExam(pageNo);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView=new ModelAndView("teacher/ExamUpdate");
        }
        return modelAndView;
    }


    //显示试卷
    @Override
    public ModelAndView teacherExam(int pageNo) {
        int num = examMapper.getCount();
        Page page=pageTools.getPage(num,pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<Exam> list = examMapper.getExam(beginNo, page.getPageSize());
        Map map = new HashMap();
        ModelAndView modelAndView = null;
        if (list.size() > 0) {
            page.setTopicList(list);
            map.put("page", page);
            modelAndView = new ModelAndView("teacher/ExamShow", map);
        }else {
            modelAndView = new ModelAndView("teacher/ExamShow");
        }
        return modelAndView;
    }

    @Override
    public ModelAndView teacherExamDelete(int e_id,int pageNo) {
        ModelAndView modelAndView=null;
        try {
            examMapper.teacherExamDeleteStrel(e_id);
            examMapper.teacherExamDeleteExam(e_id);
            modelAndView=teacherExam(pageNo);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView = new ModelAndView("teacher/ExamShow");
        }
        return modelAndView;
    }

    @Override
    public ModelAndView adminExamContent(int e_id,int pageNo) {
        ModelAndView modelAndView = null;
        Map map = examContent(e_id);
        map.put("pageNo",pageNo);
        modelAndView = new ModelAndView("teacher/ExamContent", map);
        return modelAndView;
    }

    @Override
    public ModelAndView teacherExamAdd(String exam_name, int subject, int examDate, int exam_num) {
        Map map=new HashMap();
        ModelAndView modelAndView=null;
        String tip=examAdd(exam_name,subject,examDate,exam_num);
        map.put("tip",tip);
        modelAndView=new ModelAndView("teachers/ExamAdd",map);
        return modelAndView;
    }

    @Override
    public ModelAndView teacherExamQuery(int s_id, int pageNo) {
        int num = examMapper.getTeacherExamCount(s_id);
        Page page=pageTools.getPage(num,pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<Exam> list = examMapper.getTeacherExcmQuery(s_id,beginNo, page.getPageSize());
        Map map = new HashMap();
        ModelAndView modelAndView = null;
        if (list.size() > 0) {
            page.setTopicList(list);
            map.put("page", page);
            modelAndView = new ModelAndView("teachers/ExamShow", map);
        }else {
            modelAndView = new ModelAndView("teachers/ExamShow");
        }
        return modelAndView;
    }

    @Override
    public ModelAndView teacherExamContent(int e_id, int pageNo) {
        Map map=examContent(e_id);
        map.put("pageNo",pageNo);
        ModelAndView modelAndView=new ModelAndView("/teachers/ExamContent",map);
        return modelAndView;
    }

    @Override
    public ModelAndView teacherExamBeforeUpdate(int e_id, int pageNo) {
        Map map=teacherExamUpdateBefore(e_id,pageNo);
        ModelAndView modelAndView=new ModelAndView("/teachers/ExamUpdate", map);
        return modelAndView;
    }

    @Override
    public ModelAndView teacherExamUpdate(int e_id, int pageNo,int s_id, int second, String name) {
        ModelAndView modelAndView=null;
        try {
            examMapper.teacherUpdateExam(e_id,second,name);
            modelAndView=teacherExamQuery(s_id,pageNo);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView=new ModelAndView("teachers/ExamUpdate");
        }
        return modelAndView;
    }

    @Override
    public ModelAndView teacherExamDelete(int e_id, int s_id, int pageNo) {
        ModelAndView modelAndView=null;
        try {
            examMapper.teacherExamDeleteStrel(e_id);
            examMapper.teacherExamDeleteExam(e_id);
            modelAndView=teacherExamQuery(s_id,pageNo);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView = new ModelAndView("teachers/ExamShow");
        }
        return modelAndView;
    }


    @Override
    public boolean checkExam(String exam_name) {
        boolean flag=true;
        List<Exam> list=examMapper.checkExam(exam_name);
        if (list.size()>0){
            flag=false;
        }
        return flag;
    }

    @Override
    public String examAdd(String exam_name, int subject, int examDate, int exam_num) {
        boolean flag=checkExam(exam_name);
        String tip="";
        if (flag){
            try {
                examMapper.addExam(exam_name,subject,examDate);
                List<Exam> list=examMapper.examInfo(exam_name,subject,examDate);
                Exam exam=list.get(0);
                int e_id=exam.getE_id();
                List<Question> questions=examMapper.randExam(subject,exam_num);
                if (questions.size()>0){
                    for (Question question:questions
                    ) {
                        int q_id=question.getQ_id();
                        examMapper.createExam(e_id,q_id);
                    }
                    tip="生成成功！";
                }else {
                    tip="该科目没有试题，请先生成试题！";
                }
            } catch (Exception e) {
                e.printStackTrace();
                tip="生成失败!";
            }
        }else {
            tip="已有此试卷，请勿重复生成！";
        }
        return tip;
    }


    @Override
    public Map examContent(int e_id) {
        Map map=new HashMap();
        Exam exam = examMapper.getQues(e_id);
        if (exam != null) {
            int exam_score=0;
            List<Question> list=exam.getQuestions();
            for (Question question:list
            ) {
                exam_score+=question.getMark();
            }
            map.put("exam", exam);
            map.put("exam_score",exam_score);
        }
        return map;
    }

    @Override
    public Map teacherExamUpdateBefore(int e_id, int pageNo) {
        Map map = new HashMap();
        Exam exam = examMapper.getQues(e_id);
        List<Subject> list=examMapper.getSubject();
        if (exam != null) {
            map.put("exam", exam);
            map.put("exam_id",e_id);
            map.put("pageNo",pageNo);
            map.put("subject",list);
        }
        return map;
    }

    @Override
    public ModelAndView examStatus(int e_id, int pageNo, int e_type,int s_id) {
        ModelAndView modelAndView=null;
        try {
            int Status=0;
            if (e_type==0){
                Status=1;
            }
            examMapper.updateExamStatus(e_id,Status);
            modelAndView=teacherExamQuery(s_id,pageNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @Override
    public List<Exam> getExamSelect(int s_id) {
        List<Exam> list=examMapper.getExamDesc(s_id);
        return list;
    }
    @Override
    public List<Achievement> ShowMarkByExam(int e_id) {
        List<Achievement> ShowMarkByExam = achievementMapper.getMarkDesc(e_id);
        return ShowMarkByExam;
    }

    @Override
    public Exam GetExamName(int e_id) {
        Exam ExamName= examMapper.getQues(e_id);
        return ExamName;
    }
}
