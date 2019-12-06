package day4.listener;

import javax.servlet.*;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements ServletContextListener,HttpSessionListener,ServletRequestListener{

    public void contextInitialized(ServletContextEvent e) {
        System.out.println("=============application is created===============");
        ServletContext app=e.getServletContext();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("=============application is destoried===============");
    }

    public void sessionCreated(HttpSessionEvent s) {
        System.out.println("=============session is created===============");
        System.out.println("sessionId:"+s.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("=============session is destoried===============");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("=============request is created===============");
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("=============request is destoried===============");
    }
}
