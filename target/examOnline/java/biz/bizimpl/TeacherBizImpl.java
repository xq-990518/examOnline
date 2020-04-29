package biz.bizimpl;

import biz.TeacherBiz;
import entity.Teacher;
import mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherBizImpl implements TeacherBiz {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getTeacher() {
        List<Teacher> list=teacherMapper.getSelectTeacher();
        return list;
    }
}
