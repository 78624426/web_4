package day2.demo1;

import day2.demo1.dao.IUserDao;
import org.apache.ibatis.session.SqlSession;
import util.Util;

public class Test {
    public static void main(String[] args) {
        SqlSession session= Util.getSession();
        IUserDao dao=session.getMapper(IUserDao.class);
        System.out.println(dao.selectById(1));


    }
}
