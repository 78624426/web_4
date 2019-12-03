package day3.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");
        String pass=req.getParameter("password");
        resp.setContentType("text/html;charset=utf-8");
        if("admin".equals(name)){
            if("123".equals(pass)){
                this.getServletContext().setAttribute("username",name);
                resp.getWriter().write("欢迎你：<h1>"+name+"</h1>");
            }
        }
    }
}
