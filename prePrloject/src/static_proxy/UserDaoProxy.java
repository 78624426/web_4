package static_proxy;

public class UserDaoProxy implements UserDao {
    UserDao dao=new UserDaoImpl();
    @Override
    public void transfer(String from, String to, Integer money) {
        System.out.println("开启事物");
        dao.transfer(from,to,money);
        System.out.println("关闭事物");
    }

    @Override
    public void add() {

    }

    @Override
    public void update() {

    }
}
