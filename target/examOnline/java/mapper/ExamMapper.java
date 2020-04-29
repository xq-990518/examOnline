package mapper;

import entity.Exam;
import entity.Question;
import entity.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface ExamMapper {

  @Select(" select * from exam limit #{param1},#{param2}")
  @Results({
          @Result(id = true,property = "e_id",column = "e_id"),
          @Result(property = "e_name",column = "e_name"),
          @Result(property = "e_examDate",column = "e_examDate"),
          @Result(property = "e_type",column = "e_type"),
          @Result(property = "discipline",column = "s_id",one = @One(select = "mapper.SubjectMapper.getSub")),
          @Result(property = "questions",column = "e_id",many = @Many(select = "mapper.QuestionMapper.getQues")),
          @Result(property = "achievements",column = "e_id",many = @Many(select = "mapper.AchievementMapper.getExam_A"))
  })
  List<Exam> getExam(int beginNo, int pageSize);

  @Select(" select * from exam where e_type=1 limit #{param1},#{param2}")
  @Results({
          @Result(id = true,property = "e_id",column = "e_id"),
          @Result(property = "e_name",column = "e_name"),
          @Result(property = "e_examDate",column = "e_examDate"),
          @Result(property = "e_type",column = "e_type"),
          @Result(property = "discipline",column = "s_id",one = @One(select = "mapper.SubjectMapper.getSub")),
          @Result(property = "questions",column = "e_id",many = @Many(select = "mapper.QuestionMapper.getQues")),
          @Result(property = "achievements",column = "e_id",many = @Many(select = "mapper.AchievementMapper.getExam_A"))
  })
  List<Exam> getStudentExam(int beginNo, int pageSize);

  @Select(" select count(*) from exam")
  int getCount();

  @Select(" select count(*) from exam where e_type=1")
  int getExamCount();

  @Select("select * from exam where e_id=#{e_id}")
  @Results({
          @Result(id = true,property = "e_id",column = "e_id"),
          @Result(property = "e_name",column = "e_name"),
          @Result(property = "e_examDate",column = "e_examDate"),
          @Result(property = "e_type",column = "e_type"),
          @Result(property = "discipline",column = "s_id",one = @One(select = "mapper.SubjectMapper.getSub")),
          @Result(property = "questions",column = "e_id",many = @Many(select = "mapper.QuestionMapper.getQues")),
          @Result(property = "achievements",column = "e_id",many = @Many(select = "mapper.AchievementMapper.getExam_A"))
  })
  Exam getQues(int e_id);


  @Select(" select * from exam e, strel s where e.e_id=s.e_id and s.q_id=#{q_id}")
  List<Exam> getEx(int q_id);

  @Select(" select * from exam where s_id=#{s_id}")
  List<Exam> getSubEx(int s_id);

  @Select(" select * from exam where e_name=#{param1}")
  List<Exam> checkExam(String exam_name);

  @Insert(" insert into exam values(0,#{param1},#{param2},#{param3},0)")
  void addExam(String exam_name,int subject,int exam_num);

  @Select(" select * from exam where e_name=#{param1} and s_id=#{param2} and e_examDate=#{param3}")
  List<Exam> examInfo(String exam_name,int subject,int exam_num);

  @Select(" select * from question where s_id=#{param1} ORDER BY RAND() LIMIT #{param2}")
  List<Question> randExam(int subject, int exam_num);

  @Insert(" insert into strel values(0,#{param1},#{param2})")
  void createExam(int e_id,int q_id);

  @Select(" select * from subject")
  List<Subject> getSubject();

  @Update(" update exam set e_name=#{param3},e_examDate=#{param2} where e_id=#{param1}")
  void teacherUpdateExam(int e_id,int second,String name);

  @Delete(" delete from exam  where e_id=#{e_id}")
  void teacherExamDeleteExam(int e_id);

  @Delete(" delete from strel where e_id=#{e_id}")
  void teacherExamDeleteStrel(int e_id);

  @Select(" select count(*) from exam where s_id=#{param1}")
  int getTeacherExamCount(int s_id);

  @Select(" select * from exam  where s_id=#{param1} limit #{param2},#{param3}")
  @Results({
          @Result(id = true,property = "e_id",column = "e_id"),
          @Result(property = "e_name",column = "e_name"),
          @Result(property = "e_examDate",column = "e_examDate"),
          @Result(property = "e_type",column = "e_type"),
          @Result(property = "discipline",column = "s_id",one = @One(select = "mapper.SubjectMapper.getSub")),
          @Result(property = "questions",column = "e_id",many = @Many(select = "mapper.QuestionMapper.getQues")),
          @Result(property = "achievements",column = "e_id",many = @Many(select = "mapper.AchievementMapper.getExam_A"))
  })
  List<Exam> getTeacherExcmQuery(int s_id,int beginNo, int pageSize);

  @Select("select * from exam exa,subject sub,teacher tea  where exa.s_id=sub.Subject_id and sub.Subject_id=tea.Subject_id and tea.t_id=#{param1} and tea.Subject_id=#{param2}")
  @Results({
          @Result(id = true,property = "e_id",column = "e_id"),
          @Result(property = "e_name",column = "e_name"),
          @Result(property = "e_examDate",column = "e_examDate"),
          @Result(property = "e_type",column = "e_type"),
          @Result(property = "discipline",column = "s_id",one = @One(select = "mapper.SubjectMapper.getSub")),
          @Result(property = "questions",column = "e_id",many = @Many(select = "mapper.QuestionMapper.getQues")),
          @Result(property = "achievements",column = "e_id",many = @Many(select = "mapper.AchievementMapper.getExam_A"))
  })
  List<Exam> TeaIdSubIdGetEName(int t_id,int subject_id);

  @Update(" update exam set e_type=#{param2} where e_id=#{param1}")
  void updateExamStatus(int e_id,int e_type);

  @Select(" select * from exam where s_id=#{param1} order by e_id desc")
  @Results({
          @Result(id = true,property = "e_id",column = "e_id"),
          @Result(property = "e_name",column = "e_name"),
          @Result(property = "e_examDate",column = "e_examDate"),
          @Result(property = "e_type",column = "e_type"),
          @Result(property = "discipline",column = "s_id",one = @One(select = "mapper.SubjectMapper.getSub")),
          @Result(property = "questions",column = "e_id",many = @Many(select = "mapper.QuestionMapper.getQues")),
          @Result(property = "achievements",column = "e_id",many = @Many(select = "mapper.AchievementMapper.getExam_A"))
  })
  List<Exam> getExamDesc(int s_id);

}
