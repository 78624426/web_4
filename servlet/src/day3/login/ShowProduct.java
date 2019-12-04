package day3.login;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowProduct extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[]arr=req.getCookies();
        if(arr==null){
            resp.sendRedirect(this.getServletContext().getContextPath()+"/day3/login/showLogin.html");
            return;
        }
        Boolean login=null;
        for(Cookie c:arr){
            if(c.getName().equals("name")){
                login=(Boolean)this.getServletContext().getAttribute(c.getValue());
                break;
            }
        }

        if(login==null){//还没有登录
            resp.sendRedirect(this.getServletContext().getContextPath()+"/day3/login/showLogin.html");
            return;
        }
        //已经登录成功，向产品信息页面转发
        req.getRequestDispatcher("/WEB-INF/product.html").forward(req,resp);

    }
}
