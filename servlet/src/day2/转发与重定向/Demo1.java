package day2.转发与重定向;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问了demo1");
        req.setAttribute("abc","孙悟空");
        //req.getRequestDispatcher("/day2/tr/demo2").forward(req,resp);
        resp.sendRedirect("/s/day2/tr/demo2");
    }
}
