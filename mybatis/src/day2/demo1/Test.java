package day2.demo1;

import day1.entity.User;
import day2.demo1.dao.IUserDao;
import day2.demo1.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        SqlSession session= Util.getSession();
        IUserDao dao=session.getMapper(IUserDao.class);
        User u=dao.selectById(1);
        u.setName("猪");
        dao.updateByParam(u);
        System.out.println(dao.selectByChose(u));

        List<Integer>ids=new ArrayList<>();
        ids.add(1);
        ids.add(2);
        System.out.println(dao.selectByIds(ids));
        System.out.println("=============注解===========");

        UserDao d=session.getMapper(UserDao.class);
        System.out.println(d.selectById(1));
    }
}
