package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class A {
    //java对象转字符串
    public static void main1(String[] args) {
        //把数组和对象转字符串
        int[]arr={1,2,3};
        User u=new User(new Date(),"南京",arr,true);
        String s= JSON.toJSONString(arr);
        s=JSON.toJSONString(u);

        //把集合转字符串
        Date d=new Date();
        d.setTime(12333333);
        User u2=new User(d,"北京",arr,false);
        List list=new ArrayList();
        list.add(u);
        list.add(u2);
        s=JSON.toJSONString(list);

        System.out.println(s);
    }

    //把字符串转java对象
    public static void main(String[] args) {
        int[]arr={1,2,3};
        User u=new User(new Date(),"南京",arr,true);
        String s= JSON.toJSONString(u);
        u=JSON.parseObject(s,new TypeReference<User>(){});

        System.out.println(u);

    }

}
