package day1.demo3;

import day1.entity.User;
import org.apache.ibatis.session.SqlSession;
import util.Util;

public class Test {
    public static void main(String[] args) {
        SqlSession session= Util.getSession();
        IUserDao dao=session.getMapper(IUserDao.class);

        System.out.println(dao.selectByIdAndName(4, "悟空"));
        User u=new User();
        u.setId(1);
        u.setName("admin");
        System.out.println(dao.selectByUser(u));

    }
}
