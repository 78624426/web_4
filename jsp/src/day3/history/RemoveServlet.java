package day3.history;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie c=new Cookie("product","");
        c.setMaxAge(0);
        resp.addCookie(c);
        req.getSession().setAttribute("msg","成功清除历史记录");
        resp.sendRedirect(req.getContextPath()+"/day3/history/product.jsp");
    }
}
