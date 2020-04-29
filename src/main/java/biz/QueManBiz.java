package biz;

import com.sun.org.apache.xpath.internal.operations.Mod;
import entity.Page;
import entity.Question;
import entity.Subject;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface QueManBiz {
    Page ShowAllQue(int pageNo);
    ModelAndView getSource(int s_id, int e_id, List<String> q_list, List<String> answerList);
    void DelQuestion(int QueId);
    List<Subject> SubList();
    Question getQue(int QueId);
    void UpdQue(int QueId,String QueName,String optionA,String optionB,String optionC,String optionD,String answer,String resolution,int mark,int SubId);
    void InsQue(String QueName,String optionA,String optionB,String optionC,String optionD,String answer,String resolution,int mark,int SubId);
    ModelAndView SelQuestion(int SubId,int pageNo);

    ModelAndView teacherQueryQuestion(int s_id,int pageNo);
    ModelAndView teacherInsertQuestion(String QueName,String optionA,String optionB,String optionC,String optionD,String answer,String resolution,int mark,int s_id);
    ModelAndView teahcerBeforeUpdateQuestion(int q_id,int pageNo);
    ModelAndView teacherUpdateQuestion(String QueName,String optionA,String optionB,String optionC,String optionD,String answer,String resolution,int mark,int s_id,int q_id,int pageNo);
    ModelAndView teacherDeleteQuestion(int q_id,int s_id,int pageNo);
}
