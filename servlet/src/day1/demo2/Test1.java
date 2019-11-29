package day1.demo2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class Test1 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println(req.getParameter("name"));
        OutputStream out=resp.getOutputStream();
        resp.setHeader("content-type","text/html;charset=utf-8");
        out.write("丈夫在世当有为".getBytes("utf-8"));
    }
}
