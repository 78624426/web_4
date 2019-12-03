package day3.contxt;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Serv2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is serv2....");
        ServletContext ctx=getServletContext();
        String[]arr=(String[])ctx.getAttribute("user");

        for(String t:arr){
            resp.getWriter().println(t);
        }
    }
}
