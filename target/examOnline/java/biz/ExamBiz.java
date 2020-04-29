package biz;

import entity.Achievement;
import entity.Exam;
import entity.Subject;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface ExamBiz {

    ModelAndView getExam(int s_id,int pageNo);

    ModelAndView getExam_Question(int e_id);

    ModelAndView showExamQuestion(int e_id);

    ModelAndView ExamAdd(String exam_name, int subject, int examDate, int exam_num);

    ModelAndView examBeforeUpdate(int e_id, int pageNo);

    ModelAndView examUpdate(int e_id, int pageNo,int second, String name);

    ModelAndView teacherExam(int pageNo);

    ModelAndView teacherExamDelete(int e_id, int pageNo);

    ModelAndView adminExamContent(int e_id,int pageNo);

    ModelAndView teacherExamAdd(String exam_name, int subject, int examDate, int exam_num);

    ModelAndView teacherExamQuery(int s_id,int pageNo);

    ModelAndView teacherExamContent(int e_id,int pageNo);

    ModelAndView teacherExamBeforeUpdate(int e_id,int pageNo);

    ModelAndView teacherExamUpdate(int e_id, int pageNo,int s_id, int second, String name);

    ModelAndView teacherExamDelete(int e_id,int s_id,int pageNo);

    boolean checkExam(String exam_name);

    String examAdd(String exam_name, int subject, int examDate, int exam_num);

    Map examContent(int e_id);

    Map teacherExamUpdateBefore(int e_id, int pageNo);

    ModelAndView examStatus(int e_id,int pageNo,int e_type,int s_id);

    List<Exam> getExamSelect(int s_id);
    List<Achievement> ShowMarkByExam(int e_id);
    Exam GetExamName(int e_id);

}
