package day1;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/log4j/serv")
public class Serv extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ip=req.getRemoteAddr();
        Date now=new Date();
        long begin=System.currentTimeMillis();
        for(int i=0;i<10000000;i++){}
        long end=System.currentTimeMillis();
        String msg=ip+"在时间:"+now+"访问了服务器，共用时："+(end-begin)+"毫秒";
        Logger log= Logger.getLogger(Serv.class);
        log.debug(msg);

    }
}
