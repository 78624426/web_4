package filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login.do")
public class Serv extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("user");
        String pass=req.getParameter("pass");
        if("admin".equals(user)&&"123".equals(pass)){
            req.getSession().setAttribute("user",user);
            resp.sendRedirect(req.getContextPath()+"/filter/main.jsp");
        }else{
            resp.sendRedirect(req.getContextPath()+"/filter/login.jsp");
        }
    }
}
