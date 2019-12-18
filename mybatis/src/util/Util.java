package util;

import day1.demo1.Test1;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Util {
    static SqlSessionFactory factory;
    static{
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory=builder.build(Test1.class.getClassLoader().getResourceAsStream("config/my-config.xml"));
    }
    public static SqlSession getSession(){
        SqlSession session=factory.openSession();
        return session;
    }
    public static void closeSession(SqlSession session){
        if(session!=null){
            session.close();
        }
    }

}
