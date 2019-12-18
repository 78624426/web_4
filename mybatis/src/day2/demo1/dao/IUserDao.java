package day2.demo1.dao;

import day1.entity.User;

import java.util.List;

public interface IUserDao {
    User selectById(Integer id);

    User selectByParam(User u);
    User selectByChose(User u);
    void updateByParam(User u);
    List<User> selectByIds(List<Integer>ids);

}
