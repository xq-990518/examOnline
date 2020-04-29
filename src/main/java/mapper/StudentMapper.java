package mapper;

import entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface StudentMapper {

    @Select(" select * from student where s_no=#{sNO}")
    @Results({
            @Result(id = true,property = "s_id",column = "s_id"),
            @Result(property = "s_No",column = "s_No"),
            @Result(property = "s_Name",column = "s_Name"),
            @Result(property = "tClass",column = "c_id",one = @One(select = "mapper.TClassMapper.getCla")),
            @Result(property = "achievements",column = "s_id",many = @Many(select = "mapper.AchievementMapper.getAch")),
    })
    List<Student> getLogin(String sNO);

    @Select(" select * from student where s_id=#{s_id}")
    @Results({
            @Result(id = true,property = "s_id",column = "s_id"),
            @Result(property = "s_No",column = "s_No"),
            @Result(property = "s_Name",column = "s_Name"),
            @Result(property = "tClass",column = "c_id",one = @One(select = "mapper.TClassMapper.getCla")),
            @Result(property = "achievements",column = "s_id",many = @Many(select = "mapper.AchievementMapper.getAch")),
    })
    Student getStudent(int s_id);

    @Select(" select * from student where c_id=#{param1}")
    List<Student> getStu_TC(int c_id);

    @Select(" select * from student where s_id=#{param1}")
    @Results({
            @Result(id = true,property = "s_id",column = "s_id"),
            @Result(property = "s_No",column = "s_No"),
            @Result(property = "s_Name",column = "s_Name"),
            @Result(property = "tClass",column = "c_id",one = @One(select = "mapper.TClassMapper.getCla")),
            @Result(property = "achievements",column = "s_id",many = @Many(select = "mapper.AchievementMapper.getAch")),
    })
    Student ShowStuInfo(int StuId);

    @Update("update student set s_No=#{param2},s_Name=#{param3},c_id=#{param4} where s_id=#{param1}")
    void UpdStu(int StuId,String StuNo,String StuName,int ClaId);

    @Select(" select * from student where s_no=#{param1}")
    List<Student> checkStudent(String s_no);

    @Select(" select * from student where s_id=#{param1}")
    Student checkUpdateStudent(int s_id);

    @Delete("delete from student where s_id=#{param1}")
    void DelStu(int StuId);
}
