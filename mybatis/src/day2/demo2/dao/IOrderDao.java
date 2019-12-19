package day2.demo2.dao;

import day2.demo2.entity.Order;

public interface IOrderDao {
    void insertOrder(Order o);
    Order selectById(Integer id);

}
