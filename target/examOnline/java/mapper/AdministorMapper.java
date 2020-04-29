package mapper;

import entity.Administor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface AdministorMapper {
    @Select(" select * from administor where admin_no=#{param1} and password=#{param2}")
    List<Administor> getAdmin(String admin_no, String password);
}
