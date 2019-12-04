package day3.login;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");
        String pass=req.getParameter("password");
        resp.setContentType("text/html;charset=utf-8");
        Map<String,String> m=new HashMap<>();
        m.put("wqm","123");
        m.put("gyh","hello");

        if(m.containsKey(name)){//是否包含用户名
            if(m.get(name).equals(pass)){//密码是否正确
                this.getServletContext().setAttribute(name,true);
                Cookie c=new Cookie("name",name);
                c.setPath(this.getServletContext().getContextPath());
                c.setMaxAge(60*60*24*7);
                resp.addCookie(c);
                resp.getWriter().write("恭喜你登录成功！");
                return;
            }
        }
        resp.sendRedirect(this.getServletContext().getContextPath()+"/day3/login/showLogin.html");
    }
}
