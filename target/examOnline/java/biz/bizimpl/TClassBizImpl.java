package biz.bizimpl;

import biz.TClassBiz;
import entity.Page;
import entity.TClass;
import help.PageTools;
import mapper.TClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TClassBizImpl implements TClassBiz {
    @Autowired
    private TClassMapper tClassMapper;

    PageTools pageTools = new PageTools();

    @Override
    public ModelAndView insertTClass(String c_name) {
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        try {
            boolean flag=checkTClass(c_name);
            if (flag){
                tClassMapper.insertTClass(c_name);
                map.put("tip", "添加成功！");
            }else {
                map.put("tip","已有此班级，请勿重复添加！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("tip", "添加失败，请重新添加！");
        }
        modelAndView = new ModelAndView("/teacher/classAdd", map);
        return modelAndView;
    }

    @Override
    public ModelAndView getTClas(int pageNo) {
        int num = tClassMapper.getCount();
        Page page = pageTools.getPage(num, pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<TClass> list = tClassMapper.queryClass(beginNo, page.getPageSize());
        if (list.size() > 0) {
            page.setTopicList(list);
        }
        Map map = new HashMap();
        map.put("page", page);
        ModelAndView modelAndView = new ModelAndView("/teacher/classQuery", map);
        return modelAndView;
    }

    @Override
    public ModelAndView beforeUpdate(int c_id, int pageNo) {
        TClass tClass = tClassMapper.tClass(c_id);
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        map.put("tClass", tClass);
        map.put("pageNo", pageNo);
        modelAndView = new ModelAndView("/teacher/classUpdate", map);
        return modelAndView;
    }

    @Override
    public ModelAndView Update(TClass tClass, int pageNo) {
        Map map = new HashMap();
        ModelAndView modelAndView = null;
        try {
            tClassMapper.updateTClass(tClass);
            modelAndView = getTClas(pageNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @Override
    public ModelAndView Delete(int c_id, int pageNo) {
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        try {
            tClassMapper.BeforeDelelteUpdate(c_id);
            tClassMapper.BeforeDelelteDelete(c_id);
            tClassMapper.DelelteTClass(c_id);
            modelAndView = getTClas(pageNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @Override
    public boolean checkTClass(String c_name) {
        boolean flag = true;
        List<TClass> list = tClassMapper.checkTClass(c_name);
        if (list.size()>0){
            flag=false;
        }
        return flag;
    }

    @Override
    public ModelAndView teacherQueryTClass(int t_id,int pageNo) {
        int num = tClassMapper.getTClassCount(t_id);
        Page page = pageTools.getPage(num, pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<TClass> list = tClassMapper.queryClass(beginNo, page.getPageSize());
        if (list.size() > 0) {
            page.setTopicList(list);
        }
        Map map = new HashMap();
        map.put("page", page);
        ModelAndView modelAndView = new ModelAndView("teachers/classQuery", map);
        return modelAndView;
    }

    @Override
    public ModelAndView adminTeacherBeforeAdd() {
        List<TClass> list=tClassMapper.getCla();
        Map map=new HashMap();
        for (TClass tClass:list
             ) {
        }
        map.put("tClass",list);
        ModelAndView modelAndView=new ModelAndView("/teacher/teacherAdd",map);
        return modelAndView;
    }
}
