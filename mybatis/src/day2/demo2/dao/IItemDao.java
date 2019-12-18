package day2.demo2.dao;

import day2.demo2.entity.Item;
/*
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
)


CREATE TABLE `t_item` (
  `id` int AUTO_INCREMENT primary key,
  `product` varchar(20) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  foreign key(order_id) references t_order(id)
)
* */
public interface IItemDao {
    void insertItem(Item i);
    Item selectById(int id);
}
