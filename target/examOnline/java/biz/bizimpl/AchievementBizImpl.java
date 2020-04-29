package biz.bizimpl;

import biz.AchievementBiz;
import entity.Achievement;
import entity.Page;
import help.PageTools;
import mapper.AchievementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AchievementBizImpl implements AchievementBiz {
    @Autowired
    private AchievementMapper achievementMapper;

    PageTools pageTools=new PageTools();

    @Override
    public ModelAndView getHistoryExam(int s_id,int pageNo) {
        int num=achievementMapper.getCount(s_id);
        Page page=pageTools.getPage(num,pageNo);
        int beginNo=(page.getCurrentPageNO()-1)*page.getPageSize();
        List<Achievement> list=achievementMapper.getHistoryExam(s_id,beginNo,page.getPageSize());
        Map map=new HashMap();
        ModelAndView modelAndView=null;
        if (list.size()>0){
            page.setTopicList(list);
            map.put("page",page);
            modelAndView=new ModelAndView("/student/historyExam",map);
        }else{
            modelAndView=new ModelAndView("/student/historyExam");
        }
        return modelAndView;
    }

    @Override
    public void deleteHistory(int a_id) {
        try{
            achievementMapper.deleteHistory(a_id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
