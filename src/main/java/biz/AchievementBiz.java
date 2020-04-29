package biz;

import org.springframework.web.servlet.ModelAndView;

public interface AchievementBiz {

    ModelAndView getHistoryExam(int s_id, int pageNo);

    void deleteHistory(int a_id);
}
