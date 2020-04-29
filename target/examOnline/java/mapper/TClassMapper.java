package mapper;

import entity.TClass;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Mapper
public interface TClassMapper {

    @Select(" select * from t_class where c_id=#{param1}")
    List<TClass> getCla();

    @Select("select * from t_class")
    List<TClass> ShowClass();

    @Select(" select * from t_class t,strel_tc st  where t.c_id=st.c_id and st.t_id=#{t_id}")
    List<TClass> getTClass(int t_id);

    @Insert(" insert into t_class values(0,#{param1})")
    void insertTClass(String c_name);

    @Select(" select count(*) from t_class")
    int getCount();

    @Select("select * from t_class limit #{param1},#{param2}")
    @Results({
            @Result(id = true,property = "c_id",column = "c_id"),
            @Result(property = "c_name",column = "c_name"),
            @Result(property = "students",column = "c_id",many = @Many(select = "mapper.StudentMapper.getStu_TC")),
            @Result(property = "teachers",column = "c_id",many = @Many(select = "mapper.TeacherMapper.getTea_TC"))
    })
    List<TClass> queryClass(int beginNo, int pageSize);

    @Update(" update t_class set c_name=#{c_name} where c_id=#{c_id}")
    void updateTClass(TClass tClass);

    @Select(" select * from t_class where c_id=#{param1}")
    TClass tClass(int c_id);

    @Delete(" delete from t_class where c_id=#{param1}")
    void DelelteTClass(int c_id);

    @Update(" update student set c_id=null where c_id=#{param1}")
    void BeforeDelelteUpdate(int c_id);

    @Delete(" delete from strel_tc where c_id=#{param1}")
    void BeforeDelelteDelete(int c_id);

    @Select(" select * from t_class where c_name=#{param1}")
    List<TClass> checkTClass(String c_name);

    @Select(" select count(*) from teacher t ,strel_tc tc where  t.t_id=tc.t_id and tc.t_id=#{param1}")
    int getTClassCount(int t_id);
}
