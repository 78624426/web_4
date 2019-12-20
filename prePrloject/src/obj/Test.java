package obj;

import entity.User;
import jdk_proxy.UserDao;
import util.MyBatisUtil;

public class Test {
    public static void main(String[] args) {
        User u=new User();
        u.setName("老王");
        u.setPass("hello");
        u.setId(1);
        UserDao dao=(UserDao)ObjectFactory.getObject("userDao");
        dao.add(u);
        MyBatisUtil.getSession().commit();
    }
}
