package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
    private static SqlSessionFactory sf;
    private static ThreadLocal<SqlSession> threadLocal;
    static {
        threadLocal=new ThreadLocal<>();
        try{
            sf=new SqlSessionFactoryBuilder().build(MyBatisUtil.class.getClassLoader().getResourceAsStream("config/my-config.xml"));
        }catch(Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError("MyBatisUtil文件初始化错误!");
        }
    }

    public static SqlSession getSession(){
        SqlSession session=threadLocal.get();
        try{
            if(session==null){
                session=sf.openSession();
                threadLocal.set(session);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("获取sqlSession失败",e);
        }
        return session;
    }

    public static void closeSession(){
        SqlSession session = threadLocal.get();
        if(session!=null){
            session.close();
            threadLocal.remove();
        }
    }
}
