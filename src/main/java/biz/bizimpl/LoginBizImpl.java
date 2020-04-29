package biz.bizimpl;

import biz.LoginBiz;
import entity.Administor;
import entity.Student;
import entity.Teacher;
import mapper.AdministorMapper;
import mapper.StudentMapper;
import mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginBizImpl implements LoginBiz {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private AdministorMapper administorMapper;

    @Override
    public Student getSLog(String sNo) {
        List<Student> list=studentMapper.getLogin(sNo);
        Student student=null;
        if (list.size()>0){
            student=list.get(0);
        }
        return student;
    }

    @Override
    public Teacher getTLog(String tNo, String tPassword) {
        List<Teacher> list=teacherMapper.getTea(new Teacher(tNo,tPassword));
        Teacher teacher=null;
        if (list.size()>0){
            teacher=list.get(0);
        }
        return teacher;
    }

    @Override
    public Administor getALog(String admin_no, String password) {
        List<Administor> list=administorMapper.getAdmin(admin_no,password);
        Administor administor=null;
        if (list.size()>0){
            administor=list.get(0);
        }
        return administor;
    }
}
