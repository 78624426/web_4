package obj;

import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    private static Map<String,Object> objs=new HashMap<>();
    static {
        BufferedReader br=null;
        try{
            br=new BufferedReader(new InputStreamReader(ObjectFactory.class.getClassLoader().getResourceAsStream("objects-mybatis.txt")));
            String s;
            while ((s=br.readLine())!=null){
                String[]entry=s.split("=");
                if(entry.length!=2){
                    continue;
                }
                String key=entry[0].trim();
                String value=entry[1].trim();
                Class<?>c=Class.forName(value);
                if(c.isInterface()){
                    objs.put(key,c);
                    continue;
                }
                objs.put(key,c.newInstance());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError("对象工厂初始化错误:"+e);
        }finally {
            try {
                br.close();
            } catch (IOException e) {}
        }
    }

    public static Object getObject(String key){
        Object obj=objs.get(key);
        if(obj instanceof Class){//obj是接口的类对象
            SqlSession session= MyBatisUtil.getSession();
            Object dao=session.getMapper((Class)obj);
            Object daoProxy= Proxy.newProxyInstance(dao.getClass().getClassLoader(),
                    new Class[]{(Class) obj},
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            return null;
                        }
                    }
            );
        }
    }
}
