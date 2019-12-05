package day2.demo2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class URLServ extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        req.getSession().setAttribute("name",name);
        System.out.println(req.getSession().getId());
        resp.sendRedirect(req.getContextPath()+"/day2/demo2/2.jsp"+";jsessionid="+req.getSession().getId());
    }
}
