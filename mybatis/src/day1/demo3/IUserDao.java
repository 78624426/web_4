package day1.demo3;

import day1.entity.User;
import org.apache.ibatis.annotations.Param;

public interface IUserDao {
    User selectById(Integer id);

    User selectByIdAndName(@Param("userid") Integer id, @Param("username") String name);

    User selectByUser(User u);
}
