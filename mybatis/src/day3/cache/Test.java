package day3.cache;

import day2.demo2.dao.IItemDao;
import org.apache.ibatis.session.SqlSession;
import util.Util;

public class Test {
    public static void 一级缓存(String[] args) {
        //SqlSession session=Util.getSession();
        SqlSession session=day2.demo2.Test.session;
        day2.demo2.Test.searchWithSession(session);
        //对于一级缓存，不同的session不共享缓存
        //day2.demo2.Test.searchWithSession(Util.getSession());
        day2.demo2.Test.insert();
        day2.demo2.Test.searchWithSession(session);
    }

    //二级缓存
    public static void main(String[] args) throws InterruptedException {
        SqlSession session1= Util.getSession();
        SqlSession session2=Util.getSession();
        IItemDao dao=session1.getMapper(IItemDao.class);
        System.out.println(dao.selectById(24));

        session1.commit();
        Thread.sleep(2000);
        dao=session2.getMapper(IItemDao.class);
        System.out.println(dao.selectById(24));



    }
}
