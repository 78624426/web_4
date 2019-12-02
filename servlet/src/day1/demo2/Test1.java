package day1.demo2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Test1 extends HttpServlet{
    //响应字节流乱码
    protected void s1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println(req.getParameter("name"));
        OutputStream out=resp.getOutputStream();
        resp.setHeader("content-type","text/html;charset=utf-8");
        out.write("丈夫在世当有为".getBytes("utf-8"));
    }

    //响应字符流乱码
    protected void s2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("gbk");
//        //把字符转为字节再传递到浏览器，转换时默认采用iso8859-1编码
//        resp.setHeader("content-type","text/html;charset=gbk");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.write("哈喽");
        out.println("会不乱码呢？");
    }

    //post请求字节流
    protected void s3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //默认采用iso8859-1的解码格式转为字符串,要指定跟浏览器端编码格式相同的格式才能解决
        //req.setCharacterEncoding("gbk");
        String name=req.getParameter("username");
        name=new String(name.getBytes("iso-8859-1"),"gbk");
        System.out.println(name);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");

    }
}
