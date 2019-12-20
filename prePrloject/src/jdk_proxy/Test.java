package jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        UserDao dao=new UserDaoImpl();
        //dao.add();
        Class c=dao.getClass();
        /*
     {
        InvocationHandler a=jdkProx;
        UserDao proxy=new UserDao(){
            void add(){
                a.invoke(proxy,add,add的参数);
            }

            void update(){
                a.invoke(proxy,update,update的参数);
            }
        }

        return proxy;
    }
        */
        //UserDao proxy= (UserDao) Proxy.newProxyInstance(c.getClassLoader(),c.getInterfaces(),new JdkProxy(dao));
        UserDao proxy= (UserDao) Proxy.newProxyInstance(c.getClassLoader(),c.getInterfaces(),new InvocationHandler(){
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName()+"访问了数据库");
                return method.invoke(dao,args);
            }
        });
        proxy.add();
    }

}
