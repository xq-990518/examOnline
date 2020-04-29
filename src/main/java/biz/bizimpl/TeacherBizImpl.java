package biz.bizimpl;

import biz.TeacherBiz;
import entity.Page;
import entity.Student;
import entity.Teacher;
import help.PageTools;
import mapper.SubjectMapper;
import mapper.TClassMapper;
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
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private TClassMapper tClassMapper;

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
        if (teacherMapper.getTeacherAddDecide(teacher) == null) {
            boolean flag = teacherMapper.save(teacher) > 0;
            if (flag) {
                List<Teacher> list = teacherMapper.getTea(new Teacher(teacher.getT_No(), teacher.getT_password()));
                Teacher teacher1 = ((list != null && list.size() > 0) ? list.get(0) : null);
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
        } else {
            tip = "工号已被占用，请更换工号，重新添加！";
        }

        map.put("tip", tip);
        this.getPage(map, teacherMapper.getTeacherCount(), teacherMapper.getSelectTeacher());
        modelAndView = new ModelAndView("teacher/teacherAdd", map);
        return modelAndView;
    }

    @Override
    public ModelAndView update(int pageNo, Teacher teacher, String tclass) {
        teacherMapper.updateTeacher(teacher);
        teacherMapper.updateTeacherStrel(teacher.getT_id(), Integer.parseInt(tclass));
        return this.list(pageNo);
    }

    @Override
    public ModelAndView list(int pageNo) {
        ModelAndView modelAndView = null;
        Map<String, Object> map = new HashMap<>(16);
        List<Teacher> list = teacherMapper.allTeacher();
        getPage(map, list.size(), list);
        modelAndView = new ModelAndView("teacher/teacherManager", map);
        return modelAndView;
    }

    @Override
    public ModelAndView listByName(int pageNo, String t_Name) {
        t_Name = "%" + t_Name + "%";
        ModelAndView modelAndView = null;
        Map<String, Object> map = new HashMap<>(16);
        List<Teacher> list = teacherMapper.getTeacherByName(t_Name);
        getPage(map, list.size(), list);
        modelAndView = new ModelAndView("teacher/teacherManager", map);
        return modelAndView;
    }

    @Override
    public ModelAndView listByNo(int pageNo, String t_No) {
        t_No = "%" + t_No + "%";
        ModelAndView modelAndView = null;
        Map<String, Object> map = new HashMap<>(16);
        List<Teacher> list = teacherMapper.getTeacherByNo(t_No);
        getPage(map, list.size(), list);
        modelAndView = new ModelAndView("teacher/teacherManager", map);
        return modelAndView;
    }

    @Override
    public ModelAndView listById(int pageNo, int t_id) {
        ModelAndView modelAndView = null;
        Map<String, Object> map = new HashMap<>(16);
        Teacher teacher = teacherMapper.getTeacherById(t_id);

        map.put("teacher", teacher);
        map.put("teacherSubject", teacher.getSubject());
        map.put("teacherClass", (teacher.gettClasses() != null && teacher.gettClasses().size() > 0) ? teacher.gettClasses().get(0) : null);
        map.put("pageNo", pageNo);
        map.put("subjects", subjectMapper.SubList());
        map.put("tces", tClassMapper.getTC());
        System.err.println(tClassMapper.getTC().toString());
        modelAndView = new ModelAndView("teacher/teacherUpdate", map);
        return modelAndView;
    }

    @Override
    public ModelAndView listBySubject(int pageNo, int Subject) {
        ModelAndView modelAndView = null;
        Map<String, Object> map = new HashMap<>(16);
        List<Teacher> list = teacherMapper.getSubTea(Subject);
        getPage(map, list.size(), list);
        modelAndView = new ModelAndView("teacher/teacherManager", map);
        return modelAndView;
    }

    @Override
    public ModelAndView delete(int t_id, int pageNo) {
        ModelAndView modelAndView = null;
        Map<String, Object> map = new HashMap<>(16);
        boolean flag = teacherMapper.deleteTeacherStrel(t_id) > 0;
        String tip = "";
        if (flag) {
            flag = teacherMapper.deleteTeacher(t_id) > 0;
            if (flag) {
                tip = "删除成功！";
            } else {
                tip = "删除失败!";
            }
        } else {
            tip = "删除失败!";
        }

        map.put("tip", tip);
        modelAndView = this.list(pageNo);
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
