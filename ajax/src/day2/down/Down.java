package day2.down;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/day2/down")
public class Down extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String path = getServletContext().getRealPath("/"+name);
        InputStream is=new FileInputStream(path);
        OutputStream os=resp.getOutputStream();
        byte[]arr=new byte[1024];
        int len=0;
        while((len=is.read(arr))!=-1){
            os.write(arr,0,len);
        }
        os.close();
        is.close();
    }
}
