package day2.span;

import com.alibaba.fastjson.JSON;
import day1.ajax.entity.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/p")
public class A extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setHeader("Access-Control-Allow-Origin","*");
        System.out.println("成功访问了servlet.....");
        Result rs=new Result();
        rs.setInfo("hello world");
        String r= JSON.toJSONString(rs);
        //String callback=req.getParameter("callback");
        //r=callback+"("+r+")";
        resp.getWriter().write(r);
    }
}
