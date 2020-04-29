package mapper;

import entity.Student;
import entity.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Mapper
public interface TeacherMapper{

    @Update(" update teacher set t_Name=#{t_Name}, t_No=#{t_No}, t_password=#{t_password}, Subject_id=#{subject.Subject_id} where t_id=#{t_id}")
    int updateTeacher(Teacher teacher);

    @Update(" update strel_tc set c_id=#{param2} where t_id=#{param1}")
    int updateTeacherStrel(int t_id,int c_id);

    @Insert("insert into teacher values(0,#{t_No},#{t_password},#{t_Name},#{subject.Subject_id})")
    int save(Teacher teacher);

    @Insert(" insert into strel_tc(t_id,c_id) values(#{param1},#{param2})")
    int saveStrel(int t_id,int c_id);

    @Select(" select count(1) from teacher ")
    int getTeacherCount();

    @Select(" select * from teacher where t_No=#{t_No} and t_password=#{t_password}")
    @Results({
            @Result(id = true,property = "t_id",column = "t_id"),
            @Result(property = "t_No",column = "t_No"),
            @Result(property = "t_password",column = "t_password"),
            @Result(property = "t_Name",column = "t_Name"),
            @Result(property = "subject",column = "Subject_id",one = @One(select = "mapper.SubjectMapper.getSub")),
            @Result(property = "tClasses",column = "t_id",many = @Many(select = "mapper.TClassMapper.getTClass"))
    })
    List<Teacher> getTea(Teacher teacher);

    @Select(" select * from teacher where t_No=#{t_No}")
    List<Teacher> getTeacherAddDecide(Teacher teacher);

    @Select(" select * from teacher where Subject_id=#{s_id}")
    List<Teacher> getSubTea(int s_id);

    @Select(" select * from teacher")
    List<Teacher> allTeacher();

    @Delete(" delete from strel_tc where t_id=#{t_id}")
    int deleteTeacherStrel(int t_id);

    @Delete(" delete from teacher where t_id=#{t_id}")
    int deleteTeacher(int t_id);

    @Select(" select * from teacher where t_No like #{t_No}")
    List<Teacher> getTeacherByNo(String t_No);


    @Select(" select * from teacher where t_Name like #{t_Name}")
    List<Teacher> getTeacherByName(String t_Name);

    @Select(" select * from teacher where t_id=#{id}")
    @Results({
            @Result(id = true,property = "t_id",column = "t_id"),
            @Result(property = "t_No",column = "t_No"),
            @Result(property = "t_password",column = "t_password"),
            @Result(property = "t_Name",column = "t_Name"),
            @Result(property = "subject",column = "Subject_id",one = @One(select = "mapper.SubjectMapper.getSub")),
            @Result(property = "tClasses",column = "t_id",many = @Many(select = "mapper.TClassMapper.getTClass"))
    })
    Teacher getTeacherById(int id);

    @Insert("insert into student (s_No,s_Name,c_id) values(#{param1},#{param2},#{param3})")
    void AddStu(String s_No, String s_Name, int c_id);

    @Select("select * from student limit #{param1},#{param2}")
    @Results({
            @Result(id = true, property = "s_id", column = "s_id"),
            @Result(property = "s_No", column = "s_No"),
            @Result(property = "s_Name", column = "s_Name"),
            @Result(property = "tClass", column = "c_id", one = @One(select = "mapper.TClassMapper.getCla")),
            @Result(property = "achievements", column = "s_id", many = @Many(select = "mapper.AchievementMapper.getAch")),
            @Result(property = "tClasses",column = "t_id",many = @Many(select = "mapper.TClassMapper.getTClass"))
    })
    List<Student> SelAllStu(int beginNo,int pageSize);


    @Select("Select * from student where s_No=#{param1} limit #{param2},#{param3}")
    @Results({
            @Result(id = true, property = "s_id", column = "s_id"),
            @Result(property = "s_No", column = "s_No"),
            @Result(property = "s_Name", column = "s_Name"),
            @Result(property = "tClass", column = "c_id", one = @One(select = "mapper.TClassMapper.getCla")),
            @Result(property = "achievements", column = "s_id", many = @Many(select = "mapper.AchievementMapper.getAch")),
            @Result(property = "tClasses",column = "t_id",many = @Many(select = "mapper.TClassMapper.getTClass"))
    })
    List<Student> StuById(String StuNo,int beginNo,int pageSize);

    @Select("Select * from student where c_id=#{param1} limit #{param2},#{param3}")
    @Results({
            @Result(id = true, property = "s_id", column = "s_id"),
            @Result(property = "s_No", column = "s_No"),
            @Result(property = "s_Name", column = "s_Name"),
            @Result(property = "tClass", column = "c_id", one = @One(select = "mapper.TClassMapper.getCla")),
            @Result(property = "achievements", column = "s_id", many = @Many(select = "mapper.AchievementMapper.getAch")),
            @Result(property = "tClasses",column = "t_id",many = @Many(select = "mapper.TClassMapper.getTClass"))
    })
    List<Student> StuByCla(int ClaId,int beginNo,int pageSize);

    @Select("Select * from student where s_Name=#{param1} limit #{param2},#{param3}")
    @Results({
            @Result(id = true, property = "s_id", column = "s_id"),
            @Result(property = "s_No", column = "s_No"),
            @Result(property = "s_Name", column = "s_Name"),
            @Result(property = "tClass", column = "c_id", one = @One(select = "mapper.TClassMapper.getCla")),
            @Result(property = "achievements", column = "s_id", many = @Many(select = "mapper.AchievementMapper.getAch")),
            @Result(property = "tClasses",column = "t_id",many = @Many(select = "mapper.TClassMapper.getTClass"))
    })
    List<Student> StuByName(String stuName,int beginNo,int pageSize);

    @Select(" select count(*) from student where s_name=#{param1}")
    int byStuNameCount(String stuName);



    @Select(" select count(*) from student")
    int getStuCount();

    @Select(" select count(*) from student where s_no=#{param1}")
    int byIdCount(String StuNo);

    @Select(" select count(*) from student where c_id=#{param1}")
    int byClaIdCount(int ClaId);

    @Select(" select * from teacher t,strel_tc st where t.t_id=st.t_id and st.c_id=#{param1}")
    List<Teacher> getTea_TC(int c_id);

    @Select(" select * from teacher")
    List<Teacher> getSelectTeacher();

    @Update(" update teacher set subject_id=#{param2} where t_id=#{param1}")
    void updateTeacher_subject(int t_id,int s_id);

    @Select("Select * from student where c_id=#{param1} limit #{param2},#{param3}")
    @Results({
            @Result(id = true, property = "s_id", column = "s_id"),
            @Result(property = "s_No", column = "s_No"),
            @Result(property = "s_Name", column = "s_Name"),
            @Result(property = "tClass", column = "c_id", one = @One(select = "mapper.TClassMapper.getCla")),
            @Result(property = "achievements", column = "s_id", many = @Many(select = "mapper.AchievementMapper")),
            @Result(property = "tClasses",column = "t_id",many = @Many(select = "mapper.TClassMapper.getTClass"))
    })
    List<Student> teacherQueryStudent(int ClaId,int beginNo,int pageSize);


//    select *,(@rowNum:=@rowNum+1) as rowNo from student stu,achievement ach,exam exa,(select (@rowNum :=#{param2})) rowNo
//    where stu.s_id=ach.s_id and exa.e_id=ach.e_id and stu.c_id=#{param1} and ach.e_id=#{param4} order by ach.mark desc limit #{param2},#{param3}
//    select *  from student stu,achievement ach,exam exa where stu.s_id=ach.s_id and exa.e_id=ach.e_id and stu.c_id=#{param1} and ach.e_id=#{param4} order by ach.mark desc limit #{param2},#{param3}
    @Select("select *  from student stu,achievement ach,exam exa where stu.s_id=ach.s_id and exa.e_id=ach.e_id and stu.c_id=#{param1} and ach.e_id=#{param4} order by ach.mark desc,stu.s_name limit #{param2},#{param3}")
    @Results({
            @Result(id = true, property = "s_id", column = "s_id"),
            @Result(property = "s_No", column = "s_No"),
            @Result(property = "s_Name", column = "s_Name"),
            @Result(property = "tClass", column = "c_id", one = @One(select = "mapper.TClassMapper.getCla")),
            @Result(property = "achievements", column = "s_id", many = @Many(select = "mapper.AchievementMapper.getAch")),
            @Result(property = "tClasses",column = "t_id",many = @Many(select = "mapper.TClassMapper.getTClass"))
    })
    List<Student> StuByClaOrderBy(int ClaId,int beginNo,int pageSize,int e_id);

    @Select("Select count(*) from student stu,achievement ach,exam exa where stu.s_id=ach.s_id and exa.e_id=ach.e_id and stu.c_id=#{param1} and ach.e_id=#{param2}")
    int CountStuByClaOrderBy(int ClaId,int e_id);

}
