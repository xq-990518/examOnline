package mapper;

import entity.Achievement;
import entity.Exam;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Mapper
public interface AchievementMapper {

    @Select(" select * from achievement where s_id=#{id}")
    @Results({
            @Result(id = true,property = "a_id",column = "a_id"),
            @Result(property = "mark",column = "mark"),
            @Result(property = "a_date",column = "a_date"),
            @Result(property = "student",column = "s_id",one = @One(select = "mapper.StudentMapper.getStudent")),
            @Result(property = "exam",column = "e_id",one = @One(select = "mapper.ExamMapper.getQues")),
    })
    List<Achievement> getAch(int id);

    @Select(" select * from achievement where e_id=#{e_id}")
    List<Achievement> getExam_A(int e_id);

    @Select(" select * from achievement where s_id=#{param1} limit #{param2},#{param3}")
    @Results({
            @Result(id = true,property = "a_id",column = "a_id"),
            @Result(property = "mark",column = "mark"),
            @Result(property = "a_date",column = "a_date"),
            @Result(property = "student",column = "s_id",one = @One(select = "mapper.StudentMapper.getStudent")),
            @Result(property = "exam",column = "e_id",one = @One(select = "mapper.ExamMapper.getQues")),
    })
    List<Achievement> getHistoryExam(int s_id, int beginNo, int pageNo);

    @Select(" select count(*) from achievement where s_id=#{s_id}")
    int getCount(int s_id);


    @Delete(" delete from achievement where a_id=#{param1}")
    void deleteHistory(int a_id);

    @Select(" insert into achievement values(0,#{param1},#{param2},#{param3},#{param4})")
    void insertAchievement(int e_id, String date, int mark, int s_id);

    @Select(" select * from achievement where e_id=#{param1}")// order by mark desc
    @Results({
            @Result(id = true,property = "a_id",column = "a_id"),
            @Result(property = "mark",column = "mark"),
            @Result(property = "a_date",column = "a_date"),
            @Result(property = "student",column = "s_id",one = @One(select = "mapper.StudentMapper.getStudent")),
            @Result(property = "exam",column = "e_id",one = @One(select = "mapper.ExamMapper.getQues")),
    })
    List<Achievement> getMarkDesc(int e_id);

    @Select(" select * from achievement where s_id=#{param1}")
    @Results({
            @Result(id = true,property = "a_id",column = "a_id"),
            @Result(property = "mark",column = "mark"),
            @Result(property = "a_date",column = "a_date"),
            @Result(property = "student",column = "s_id",one = @One(select = "mapper.StudentMapper.getStudent")),
            @Result(property = "exam",column = "e_id",one = @One(select = "mapper.ExamMapper.getQues")),
    })
    List<Achievement> getExamShow(int s_id);

}
