package day4.serv3;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/day4/serv3/hello",initParams = {@WebInitParam(name="driver",value="mysql"),@WebInitParam(name="url",value="localhost")},loadOnStartup = 0)
public class Hello extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("3.0新特性");
        ServletConfig cfg=this.getServletConfig();
        System.out.println("driver:"+cfg.getInitParameter("driver"));
        req.getSession().setAttribute("username","laowang");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        req.getSession().removeAttribute("username");
    }
}
