package day2.demo2.entity;

import java.util.HashSet;
import java.util.Set;

public class Order {
    Integer id;
    String no;
    Set<Item> items=new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", items=" + items +
                '}';
    }
}
