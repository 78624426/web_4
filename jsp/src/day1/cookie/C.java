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
    void select(HttpServletRequest req, HttpServletResponse resp){

    }
    void delete(HttpServletRequest req, HttpServletResponse resp){

    }
    void modify(HttpServletRequest req, HttpServletResponse resp){

    }
}
