package static_proxy;

public class UserDaoImpl implements UserDao {

    @Override
    public void transfer(String from, String to, Integer money) {

    }

    @Override
    public void add() {
        System.out.println("添加用户成功");
    }

    @Override
    public void update() {
        System.out.println("修改用户成功");
    }
}
