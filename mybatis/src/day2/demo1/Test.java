package day2.demo1;

import day1.entity.User;
import day2.demo1.dao.IUserDao;
import org.apache.ibatis.session.SqlSession;
import util.Util;

public class Test {
    public static void main(String[] args) {
        SqlSession session= Util.getSession();
        IUserDao dao=session.getMapper(IUserDao.class);
        User u=dao.selectById(1);
        u.setName("猪");
        dao.updateByParam(u);
        System.out.println(dao.selectByChose(u));


    }
}
