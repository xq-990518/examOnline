package biz.bizimpl;

import biz.SubjectBiz;
import entity.Page;
import entity.Subject;
import entity.Teacher;
import help.PageTools;
import mapper.SubjectMapper;
import mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubjectBizImpl implements SubjectBiz {
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    PageTools pageTools = new PageTools();

    @Override
    public ModelAndView subjectAdd(int t_id, String c_name) {
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        try {
            String str = checkSubject(c_name, t_id);
            if (str.equals("noTClass")) {
                subjectMapper.inserSubject(c_name);
                List<Subject> list = subjectMapper.getSubject_id(c_name);
                if (list.size() > 0) {
                    teacherMapper.updateTeacher_subject(t_id, list.get(0).getSubject_id());
                }
                map.put("tip", "添加成功！");
            } else if (str.equals("okAdd")) {
                List<Subject> list = subjectMapper.getSubject_id(c_name);
                if (list.size() > 0) {
                    teacherMapper.updateTeacher_subject(t_id, list.get(0).getSubject_id());
                }
                map.put("tip", "已有此班级，当前班级中无此老师，添加成功！");
            } else {
                map.put("tip", "已有此班级或者当前班级中已有此老师，请勿重复录入！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("tip", "添加失败！");
        }
        modelAndView = new ModelAndView("/teacher/courseAdd", map);
        return modelAndView;

    }

    @Override
    public ModelAndView subjectQuery(int pageNo) {
        int num = subjectMapper.getCount();
        Page page = pageTools.getPage(num, pageNo);
        int beginNo = (page.getCurrentPageNO() - 1) * page.getPageSize();
        List<Subject> list = subjectMapper.subjectQuery(beginNo, page.getPageSize());
        ModelAndView modelAndView = null;
        Map map = new HashMap();
        if (list.size() > 0) {
            page.setTopicList(list);
        }
        map.put("page", page);
        modelAndView = new ModelAndView("/teacher/courseQuery", map);
        return modelAndView;
    }

    @Override
    public ModelAndView subjectBeforeUpdate(int subject_id, int pageNo) {
        Subject subject = subjectMapper.getSub(subject_id);
        Map map = new HashMap();
        map.put("subject", subject);
        map.put("pageNo", pageNo);
        ModelAndView modelAndView = new ModelAndView("/teacher/courseUpdate", map);
        return modelAndView;
    }

    @Override
    public ModelAndView subjectUpdate(int subject_id, String subject_name, int pageNo) {
        ModelAndView modelAndView = null;
        try {
            subjectMapper.subjectUpdate(new Subject(subject_id, subject_name));
            modelAndView = subjectQuery(pageNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @Override
    public ModelAndView subjectdelete(int subject_id, int pageNo) {
        ModelAndView modelAndView = null;
        try {
            subjectMapper.beforeDeleteUpdateExam(subject_id);
            subjectMapper.beforeDeleteUpdateTeacher(subject_id);
            subjectMapper.beforeDeleteUpdateQuestion(subject_id);
            subjectMapper.subjectDelete(subject_id);
            modelAndView = subjectQuery(pageNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @Override
    public String checkSubject(String c_name, int t_id) {
        String str = "";
        List<Subject> subjects = subjectMapper.checkSubject(c_name);
        if (subjects.size() > 0) {
            int num=0;
            for (Subject subject : subjects
            ) {
                if (subject != null) {
                    List<Teacher> list = subject.getTeachers();
                    for (Teacher teacher : list
                    ) {
                        if (teacher.getT_id() == t_id) {
                            num++;
                        }
                    }
                    if (num==0){
                        str = "okAdd";
                    }else {
                        str="noAdd";
                    }
                }
            }
        } else {
            str = "noTClass";
        }
        return str;

    }
}
