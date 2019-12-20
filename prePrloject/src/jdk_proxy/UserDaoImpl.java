package jdk_proxy;


import entity.User;

public class UserDaoImpl implements UserDao {

    @Override
    public void add(User u) {
        System.out.println("添加用户成功");
    }

    @Override
    public void update(User u) {
        System.out.println("修改用户成功");
    }
}
