package jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy implements InvocationHandler {
    UserDao userDao;

    public JdkProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    //参数1：老板类，也就是代理对象
    //参数2：接口中的某个方法
    //参数3：某个方法的参数
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"访问了数据库");
        return method.invoke(userDao,args);
    }
}
