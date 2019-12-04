package day1.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class C extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath=req.getServletPath();
        String contextPath=req.getContextPath();
        String urlPath=req.getRequestURI().toString();
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("servlet:"+servletPath+",contxt:"+contextPath+",url:"+urlPath);
        if(urlPath.endsWith("add")){
            add(req,resp);
        }else if(urlPath.endsWith("select")){
            select(req,resp);
        }else if(urlPath.endsWith("delete")){
            delete(req,resp);
        }else if(urlPath.endsWith("modify")){
            modify(req,resp);
        }
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie c=new Cookie("admin","123");
        resp.addCookie(c);

        c=new Cookie("phone","1351656689");
        c.setPath("/jsp/day1/2");
        resp.addCookie(c);

        resp.getWriter().write("<h1>写入cookie成功</>");
    }
    void select(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("服务器端从客户端收到的cookie信息如下：");
        Cookie[]arr=req.getCookies();
        if(arr==null){
            resp.getWriter().write("你没有cookie");
            return;
        }
        for(Cookie c:arr){
            System.out.println(c.getName()+":"+c.getValue());
        }
    }
    void delete(HttpServletRequest req, HttpServletResponse resp){
        Cookie c=new Cookie("admin","dddd");
        c=new Cookie("phone","dddd");
        c.setMaxAge(0);
        c.setPath("/jsp/day1/2");
        resp.addCookie(c);
    }
    void modify(HttpServletRequest req, HttpServletResponse resp){
        Cookie c=new Cookie("admin","dddd");
        c.setMaxAge(3600*24*7);
        resp.addCookie(c);
    }
}
