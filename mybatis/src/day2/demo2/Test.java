package day2.demo2;

import day2.demo2.dao.IItemDao;
import day2.demo2.dao.IOrderDao;
import day2.demo2.entity.Item;
import day2.demo2.entity.Order;
import org.apache.ibatis.session.SqlSession;
import util.Util;

import java.util.Random;

public class Test {
    static SqlSession session= Util.getSession();
    static IOrderDao orderDao=session.getMapper(IOrderDao.class);
    static IItemDao itemDao=session.getMapper(IItemDao.class);
    //insert
    public static void main(String[] args) {
        Order order=new Order();
        order.setNo(getNo(4));

        Item i1=new Item();
        i1.setProduct("绿茶");
        i1.setNum(2);

        Item i2=new Item();
        i2.setProduct("啤酒");
        i2.setNum(3);

        i1.setOrder(order);
        i2.setOrder(order);

        orderDao.insertOrder(order);
        System.out.println(i1.getOrder().getId());

    }

    static String getNo(int len){
        Random r=new Random();
        StringBuilder sb=new StringBuilder(len);
        for(int i=0;i<len;i++){
            if(r.nextBoolean()){//小写
                sb.append('a'+r.nextInt(26));
            }else{
                sb.append('A'+r.nextInt(26));
            }
        }
        return sb.toString();
    }
}
