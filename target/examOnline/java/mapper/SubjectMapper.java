package mapper;

import entity.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface SubjectMapper {


   @Select(" select * from subject where Subject_id=#{s_id}")
   @Results({
           @Result(id = true,property = "Subject_id",column = "Subject_id"),
           @Result(property = "Subject_name",column = "Subject_name"),
           @Result(property = "teachers",column = "Subject_id",many = @Many(select = "mapper.TeacherMapper.getSubTea")),
           @Result(property = "exams",column = "Subject_id",many = @Many(select = "mapper.ExamMapper.getSubEx")),
           @Result(property = "questions",column = "Subject_id",many = @Many(select = "mapper.QuestionMapper.getQuestion")),
   })
   Subject getSub(int s_id);


   @Select("select * from subject")
   List<Subject> SubList();
   @Insert(" insert into subject(subject_name) values(#{param1})")
   void inserSubject(String subject_name);

   @Select("select * from subject where subject_name=#{param1}")
   List<Subject> getSubject_id(String subject_name);

   @Select(" select * from subject limit #{param1},#{param2}")
   @Results({
           @Result(id = true,property = "Subject_id",column = "Subject_id"),
           @Result(property = "Subject_name",column = "Subject_name"),
           @Result(property = "teachers",column = "Subject_id",many = @Many(select = "mapper.TeacherMapper.getSubTea")),
           @Result(property = "exams",column = "Subject_id",many = @Many(select = "mapper.ExamMapper.getSubEx")),
           @Result(property = "questions",column = "Subject_id",many = @Many(select = "mapper.QuestionMapper.getQuestion")),
   })
   List<Subject> subjectQuery(int beginNo,int pageSize);

   @Select(" select count(*) from subject")
   int getCount();

   @Update(" update subject set subject_name=#{Subject_name} where subject_id=#{Subject_id}")
   void subjectUpdate(Subject subject);

   @Delete(" delete from subject where subject_id=#{param1}")
   void subjectDelete(int subject_id);

   @Update(" update teacher set Subject_id=null where Subject_id=#{param1}")
   void beforeDeleteUpdateTeacher(int subject_id);

   @Update(" update exam set s_id=null where s_id=#{subject_id}")
   void  beforeDeleteUpdateExam(int subject_id);

   @Update(" update question set s_id=null where s_id=#{param1}")
   void beforeDeleteUpdateQuestion(int subject_id);

   @Select(" select * from subject  where subject_name=#{param1}")
   @Results({
           @Result(id = true,property = "Subject_id",column = "Subject_id"),
           @Result(property = "Subject_name",column = "Subject_name"),
           @Result(property = "teachers",column = "Subject_id",many = @Many(select = "mapper.TeacherMapper.getSubTea")),
           @Result(property = "exams",column = "Subject_id",many = @Many(select = "mapper.ExamMapper.getSubEx")),
           @Result(property = "questions",column = "Subject_id",many = @Many(select = "mapper.QuestionMapper.getQuestion")),
   })
   List<Subject> checkSubject(String subject_name);
}
