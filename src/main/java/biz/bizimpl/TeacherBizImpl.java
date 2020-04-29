package biz.bizimpl;

import biz.TeacherBiz;
import entity.Page;
import entity.Student;
import entity.Teacher;
import help.PageTools;
import mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherBizImpl implements TeacherBiz {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getTeacher() {
        List<Teacher> list = teacherMapper.getSelectTeacher();
        return list;
    }

    @Override
    public ModelAndView save(Teacher teacher, String tclass) {
        ModelAndView modelAndView = null;
        boolean flag = teacherMapper.save(teacher) > 0;
        Map<String, Object> map = new HashMap<>(16);
        String tip = "";
        if (flag) {
            List<Teacher> list = teacherMapper.getTea(new Teacher(teacher.getT_Name(), teacher.getT_password()));
            Teacher teacher1 = list != null ? list.get(0) : null;
            flag = teacherMapper.save(teacher1.getT_id(), Integer.parseInt(tclass)) > 0;
            if (flag) {
                tip = "添加成功！";
            } else {
                tip = "添加失败！";
            }
        } else {
            tip = "添加失败！";
        }
        map.put("tip", tip);
        this.getPage(map, teacherMapper.getTeacherCount(),teacherMapper.getSelectTeacher());
        modelAndView = new ModelAndView("teacher/teacherManager", map);
        return modelAndView;
    }


    private void getPage(Map<String, Object> map, int num, List list) {
        PageTools pageTools = new PageTools();
        Page page = pageTools.getPage(num, 1);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        if (list.size() > 0) {
            page.setTopicList(list);
        }
        map.put("page", page);
    }
}
