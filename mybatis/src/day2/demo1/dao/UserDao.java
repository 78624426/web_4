package day2.demo1.dao;

import day1.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select id,name,pass,phone,address from t_user where id=#{id}")
    User selectById(Integer id);


}
