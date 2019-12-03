package day2.路径;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

public class Demo1 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext app=this.getServletContext();

        System.out.println(app.getRealPath("servlet路径："+req.getServletPath()));
        System.out.println("请求方法："+req.getMethod());
        System.out.println("协议版本："+req.getProtocol());
        System.out.println("根路径："+app.getRealPath("/"));
        Enumeration<String> e=req.getHeaderNames();
        while(e.hasMoreElements()){
            String k=e.nextElement();
            System.out.println(k+":"+req.getHeader(k));
        }
        System.out.println("============================");
        System.out.println(req.getParameter("name"));
        String[]arr=req.getParameterValues("name");
        for(String t:arr){
            System.out.println(t);
        }
        System.out.println("==========================");
        e=req.getParameterNames();
        while(e.hasMoreElements()){
            String k=e.nextElement();
            System.out.println(k+":"+req.getParameter(k));
        }
        System.out.println("=========map==============");
        Map<String,String[]> m=req.getParameterMap();
        int a=1/0;
        resp.getWriter().println("success");

    }
}
