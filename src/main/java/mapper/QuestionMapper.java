package mapper;

import entity.Question;
import entity.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface QuestionMapper {
   /* @Results({
            @Result(id = true,property = "cid",column = "c_id"),
            @Result(property = "",""),
            @Result(property = "",""),
            @Result(property = "",""),
            @Result(property = "",""),
    })*/

   @Select(" select * from question q,strel s where s.q_id=q.q_id and e_id=#{id}")
   @Results({
           @Result(id = true,property = "q_id",column = "q_id"),
           @Result(property = "q_name",column = "q_name"),
           @Result(property = "optionA",column = "optionA"),
           @Result(property = "optionB",column = "optionB"),
           @Result(property = "optionC",column = "optionC"),
           @Result(property = "optionD",column = "optionD"),
           @Result(property = "mark",column = "mark"),
           @Result(property = "answer",column = "answer"),
           @Result(property = "resolution",column = "resolution"),
           @Result(property = "subject",column = "s_id",one = @One(select = "mapper.SubjectMapper.getSub")),
           @Result(property = "exams",column = "q_id",many = @Many(select = "mapper.ExamMapper.getEx"))
   })
   List<Question> getQues(int id);

   @Select(" select * from question where s_id=#{param1} limit #{param2},#{param3}")
   @Results({
           @Result(id = true,property = "q_id",column = "q_id"),
           @Result(property = "q_name",column = "q_name"),
           @Result(property = "optionA",column = "optionA"),
           @Result(property = "optionB",column = "optionB"),
           @Result(property = "optionC",column = "optionC"),
           @Result(property = "optionD",column = "optionD"),
           @Result(property = "mark",column = "mark"),
           @Result(property = "answer",column = "answer"),
           @Result(property = "resolution",column = "resolution"),
           @Result(property = "subject",column = "s_id",one = @One(select = "mapper.SubjectMapper.getSub")),
           @Result(property = "exams",column = "q_id",many = @Many(select = "mapper.ExamMapper.getEx"))
   })
   List<Question> getQuestion(int SubId,int beginNo,int pageSize);

   @Select("select * from question limit #{param1},#{param2}")
   @Results({
           @Result(id = true,property = "q_id",column = "q_id"),
           @Result(property = "q_name",column = "q_name"),
           @Result(property = "optionA",column = "optionA"),
           @Result(property = "optionB",column = "optionB"),
           @Result(property = "optionC",column = "optionC"),
           @Result(property = "optionD",column = "optionD"),
           @Result(property = "mark",column = "mark"),
           @Result(property = "answer",column = "answer"),
           @Result(property = "resolution",column = "resolution"),
           @Result(property = "subject",column = "s_id",one = @One(select = "mapper.SubjectMapper.getSub")),
           @Result(property = "exams",column = "q_id",many = @Many(select = "mapper.ExamMapper.getEx"))
   })
   List<Question> ShowAllQue(int beginNo,int pageNo);

   //分页
   @Select(" select count(*) from question")
   int getCount();

   @Select(" select count(*) from question where s_id=#{param1}")
   int getCourseCount(int subject_id);

   @Select(" select * from question where q_id=#{param1} and answer=#{param2}")
   Question getSource(int q_id,String answer);

   @Delete("delete from question where q_id=#{param1}")
   void DelQuestion(int QueId);

   @Select("select * from question where q_id=#{param1}")
   @Results({
           @Result(id = true,property = "q_id",column = "q_id"),
           @Result(property = "q_name",column = "q_name"),
           @Result(property = "optionA",column = "optionA"),
           @Result(property = "optionB",column = "optionB"),
           @Result(property = "optionC",column = "optionC"),
           @Result(property = "optionD",column = "optionD"),
           @Result(property = "mark",column = "mark"),
           @Result(property = "answer",column = "answer"),
           @Result(property = "resolution",column = "resolution"),
           @Result(property = "subject",column = "s_id",one = @One(select = "mapper.SubjectMapper.getSub")),
           @Result(property = "exams",column = "q_id",many = @Many(select = "mapper.ExamMapper.getEx"))
   })
   Question getQue(int QueId);

   @Update("update question set q_name=#{param2},optionA=#{param3},optionB=#{param4},optionC=#{param5},optionD=#{param6},answer=#{param7},resolution=#{param8},mark=#{param9},s_id=#{param10} where q_id=#{param1}")
   void UpdQue(int QueId,String QueName,String optionA,String optionB,String optionC,String optionD,String answer,String resolution,int mark,int SubId);

   @Insert("insert into question (q_name,optionA,optionB,optionC,optionD,answer,resolution,mark,s_id)values(#{param1},#{param2},#{param3},#{param4},#{param5},#{param6},#{param7},#{param8},#{param9})")
   void InsQue(String QueName,String optionA,String optionB,String optionC,String optionD,String answer,String resolution,int mark,int SubId);

   @Select("select * from question where s_id=#{param1} limit #{param2},#{param3}")
   @Results({
           @Result(id = true,property = "q_id",column = "q_id"),
           @Result(property = "q_name",column = "q_name"),
           @Result(property = "optionA",column = "optionA"),
           @Result(property = "optionB",column = "optionB"),
           @Result(property = "optionC",column = "optionC"),
           @Result(property = "optionD",column = "optionD"),
           @Result(property = "mark",column = "mark"),
           @Result(property = "answer",column = "answer"),
           @Result(property = "resolution",column = "resolution"),
           @Result(property = "subject",column = "s_id",one = @One(select = "mapper.SubjectMapper.getSub")),
           @Result(property = "exams",column = "q_id",many = @Many(select = "mapper.ExamMapper.getEx"))
   })
   List<Question> teacherQueryQuestion(int s_id,int beginNo,int pageNo);

   @Select(" select count(*) from question where s_id=#{param1}")
   int teacherQueryCount(int s_id);

   @Update("update question set q_name=#{param2},optionA=#{param3},optionB=#{param4},optionC=#{param5},optionD=#{param6},answer=#{param7},resolution=#{param8},mark=#{param9} where q_id=#{param1}")
   void teacherQuestionUpdate(int QueId,String QueName,String optionA,String optionB,String optionC,String optionD,String answer,String resolution,int mark);

   @Delete(" delete from strel where q_id=#{q_id}")
   void teacherDelQuestion(int q_id);
}
