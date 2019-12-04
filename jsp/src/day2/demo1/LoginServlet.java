package day2.demo1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        String user=req.getParameter("user");
        req.setAttribute("u",user);
        HttpSession session=req.getSession();
        session.setAttribute("u",user);
        req.getRequestDispatcher("/day2/demo1/success.jsp").forward(req,resp);
        //resp.sendRedirect(req.getContextPath()+"/day2/demo1/success.jsp");
    }
}
