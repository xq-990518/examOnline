package biz.bizimpl;

import biz.QueManBiz;
import entity.Page;
import entity.Question;
import entity.Subject;
import help.PageTools;
import mapper.AchievementMapper;
import mapper.QuestionMapper;
import mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QueManImpl implements QueManBiz {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private AchievementMapper achievementMapper;

    PageTools pageTools = new PageTools();

    @Override
    public Page ShowAllQue(int pageNo) {
        int num = questionMapper.getCount();
        Page page = pageTools.getPage(num, pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<Question> ShowAllQue = questionMapper.ShowAllQue(beginNo, page.getPageSize());
        if (ShowAllQue.size() > 0) {
            page.setTopicList(ShowAllQue);
        }
        return page;
    }
    @Override
    public ModelAndView getSource(int s_id, int e_id, List<String> q_list, List<String> answerList) {
        int score=0;
        Map map=new HashMap();
        ModelAndView modelAndView=null;
        int size=0;
        if (q_list.size()>=answerList.size()){
            size=answerList.size();
        }else {
            size=q_list.size();
        }
        for (int i = 0; i <size ; i++) {
            if (answerList.get(i)!=""){
                try {
                    int id=Integer.parseInt(q_list.get(i));
                    String answer=answerList.get(i);
                    Question question=questionMapper.getSource(id,answer);
                    if (question!=null){
                        score+=question.getMark();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        try {
            achievementMapper.insertAchievement(e_id,df.format(date),score,s_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("e_id",e_id);
        map.put("score",score);
        modelAndView=new ModelAndView("/student/result",map);
        return modelAndView;
    }

    @Override
    public void DelQuestion(int QueId) {
        questionMapper.DelQuestion(QueId);
    }

    @Override
    public List<Subject> SubList() {
        List<Subject> SubList=subjectMapper.SubList();
        return SubList;
    }

    @Override
    public Question getQue(int QueId) {
        Question getQue = questionMapper.getQue(QueId);
        return getQue;
    }

    @Override
    public void UpdQue(int QueId, String QueName, String optionA, String optionB, String optionC, String optionD, String answer, String resolution, int mark,int SubId) {
        questionMapper.UpdQue(QueId, QueName, optionA, optionB, optionC, optionD, answer, resolution, mark,SubId);
    }

    @Override
    public void InsQue(String QueName, String optionA, String optionB, String optionC, String optionD, String answer, String resolution, int mark, int SubId) {
        questionMapper.InsQue(QueName, optionA, optionB, optionC, optionD, answer, resolution, mark, SubId);
    }

    @Override
    public ModelAndView SelQuestion(int SubId,int pageNo) {
        int num=questionMapper.getCourseCount(SubId);
        Page page=pageTools.getPage(num,pageNo);
        int beginNo=(page.getCurrentPageNO()-1)*page.getPageSize();
        List<Question> SelQuestion=questionMapper.getQuestion(SubId,beginNo,page.getPageSize());
        Map map=new HashMap();
        if (SelQuestion.size()>0){
            page.setTopicList(SelQuestion);
        }
        map.put("page",page);
        map.put("subject_id",SubId);
        ModelAndView modelAndView=new ModelAndView("/teacher/subjectManagerByCourse",map);
        return modelAndView;
    }

    @Override
    public ModelAndView teacherQueryQuestion(int s_id, int pageNo) {
        Map map=new HashMap();
        ModelAndView modelAndView=null;
        int num=questionMapper.teacherQueryCount(s_id);
        Page page = pageTools.getPage(num, pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<Question> list=questionMapper.teacherQueryQuestion(s_id,beginNo,page.getPageSize());
        if (list.size()>0){
            page.setTopicList(list);
        }
        map.put("page",page);
        modelAndView=new ModelAndView("/teachers/subjectManager",map);
        return modelAndView;
    }

    @Override
    public ModelAndView teacherInsertQuestion(String QueName, String optionA, String optionB, String optionC, String optionD, String answer, String resolution, int mark, int s_id) {
        Map map=new HashMap();
        ModelAndView modelAndView=null;
        String tip="";
        try {
            questionMapper.InsQue(QueName, optionA, optionB, optionC, optionD, answer, resolution, mark, s_id);
            tip="添加成功！";
        } catch (Exception e) {
            e.printStackTrace();
            tip="添加失败！";
        }
        map.put("tip",tip);
        modelAndView=new ModelAndView("/teachers/subjectAdd",map);
        return modelAndView;
    }

    @Override
    public ModelAndView teahcerBeforeUpdateQuestion(int q_id, int pageNo) {
        Map map=new HashMap();
        ModelAndView modelAndView=null;
        Question question=questionMapper.getQue(q_id);
        map.put("question",question);
        map.put("pageNo",pageNo);
        modelAndView=new ModelAndView("/teachers/subjectUpdate",map);
        return modelAndView;
    }

    @Override
    public ModelAndView teacherUpdateQuestion(String QueName, String optionA, String optionB, String optionC, String optionD, String answer, String resolution, int mark, int s_id,int q_id, int pageNo) {
        Map map=new HashMap();
        ModelAndView modelAndView=null;
        try {
            questionMapper.teacherQuestionUpdate(q_id,QueName,optionA,optionB,optionC,optionD,answer,resolution,mark);
            modelAndView=teacherQueryQuestion(s_id,pageNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @Override
    public ModelAndView teacherDeleteQuestion(int q_id, int s_id, int pageNo) {
        ModelAndView modelAndView=null;
        Map map=new HashMap();
        String tip="";
        try {
            questionMapper.teacherDelQuestion(q_id);
            questionMapper.DelQuestion(q_id);
            modelAndView=teacherQueryQuestion(s_id,pageNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
