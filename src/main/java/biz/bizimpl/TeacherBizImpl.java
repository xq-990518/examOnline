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
        Map<String, Object> map = new HashMap<>(16);
        String tip = "";
        if (teacherMapper.getTeacherAddDecide(teacher)==null){
            boolean flag = teacherMapper.save(teacher) > 0;
            if (flag) {
                List<Teacher> list = teacherMapper.getTea(new Teacher(teacher.getT_No(), teacher.getT_password()));
                Teacher teacher1 = ((list != null&& list.size()>0 )? list.get(0) : null);
                System.err.println(teacher1.toString());
                flag = teacherMapper.saveStrel(teacher1.getT_id(), Integer.parseInt(tclass)) > 0;
                if (flag) {
                    tip = "添加成功！";
                } else {
                    tip = "添加失败！";
                }
            } else {
                tip = "添加失败！";
            }
        }else {
            tip="工号已被占用，请更换工号，重新添加！";
        }

        map.put("tip", tip);
        this.getPage(map, teacherMapper.getTeacherCount(),teacherMapper.getSelectTeacher());
        modelAndView = new ModelAndView("teacher/teacherAdd", map);
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
