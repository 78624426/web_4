package day4.serv3;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
@WebListener
public class MyListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent e) {
        HttpSession session=e.getSession();
        System.out.println(e.getName()+","+e.getValue());
    }
    public void attributeRemoved(HttpSessionBindingEvent e) {
        System.out.println("属性值被删除了:"+e.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
