package day3.contxt;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Serv1 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext ctx=this.getServletContext();
        //作用1：用来获取应用名
        System.out.println(ctx.getContextPath());


        //作用2：获取全局配置参数
        String phone=ctx.getInitParameter("phone");
        System.out.println(phone);

        //作用3：作为域对象
        String[]arr={"a1","a2"};
        ctx.setAttribute("user",arr);
        //resp.sendRedirect(ctx.getContextPath()+"/day3/contxt/serv2");

        //作用4：读取资源文件

        String path = ctx.getRealPath("/WEB-INF/classes/config.properties");
        //写项目指定文件
        FileWriter fw=new FileWriter(path);
        fw.write("hello=123");
        fw.close();


        //读项目指定文件
        //直接获取输流ctx.getResourceAsStream("/WEB-INF/classes/config.properties");
        //
        FileReader fr=new FileReader(path);
        BufferedReader br=new BufferedReader(fr);
        System.out.println(br.readLine());
        br.close();


    }
}
