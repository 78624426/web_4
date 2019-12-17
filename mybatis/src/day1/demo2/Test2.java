package day1.demo2;

import day1.entity.User;
import org.apache.ibatis.session.SqlSession;
import util.Util;

public class Test2 {
    public static void main(String[] args) {
        SqlSession session= Util.getSession();
        User u=new User();
        u.setName("悟空");
        u.setPass("123");
        u.setPhone("156");
        u.setAddress("西安");
        session.insert("dao.IUserDao.insertUser",u);
        session.commit();
        System.out.println("所插入的主键值："+u.getId());


    }
}
