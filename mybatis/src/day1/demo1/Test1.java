package day1.demo1;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test1 {
    public static void main(String[] args) {
        //1.读取配置文件
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(Test1.class.getClassLoader().getResourceAsStream("day1/my-config.xml"));

        //2.获取SqlSession对象，是持久化管理器
        SqlSession session=factory.openSession();

        //3.操作数据库,如果返回多个，用selectList,"%a%"
        Object o=session.selectOne("dao.IUserDao.selectById",100);
        session.close();
        System.out.println(o);

    }
}
