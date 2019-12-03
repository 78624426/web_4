package day3.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowProduct extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=(String)this.getServletContext().getAttribute("username");
        if(name==null){//去登录
            resp.sendRedirect(this.getServletContext().getContextPath()+"/day3/login/showLogin.html");
            return;
        }

        req.getRequestDispatcher("/day3/login/product.html").forward(req,resp);

    }
}
