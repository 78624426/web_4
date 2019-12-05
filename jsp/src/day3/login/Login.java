package day3.login;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String pass=req.getParameter("pass");
        String rm=req.getParameter("rm");
        System.out.println("name="+name+",pass="+pass+",rm="+rm);
        if(!("admin".equals(name)&&"123".equals(pass))){
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("/day3/login/login.jsp").forward(req,resp);
            return;
        }

        //能走到此处，说明用户名及密码一定正确
        if(rm!=null){
            Cookie cn=new Cookie("name",name);
            Cookie cp=new Cookie("pass",pass);
            cn.setMaxAge(7*24*60*60);
            cp.setMaxAge(7*24*60*60);
            resp.addCookie(cn);
            resp.addCookie(cp);
        }

        resp.sendRedirect(req.getContextPath()+"/day3/login/success.jsp");

    }
}
