package day2.demo1.dao;

import day1.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {
    User selectById(Integer id);

    User selectByIdAndName(@Param("userid") Integer id, @Param("username") String name);

    User selectByUser(User u);
    void insertUser(User u);
    void deleteById(Integer id);
    void updateByUserId(User u);
    List<User> selectAllUser();
}
