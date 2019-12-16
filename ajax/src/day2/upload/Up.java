package day2.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/day2/upload/up")
@MultipartConfig
public class Up extends HttpServlet{
    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Part p=req.getPart("f");
        //req.getParts();如果多文件上传，则获取part集合
        String tmp=p.getHeader("Content-Disposition");
        System.out.println("header中内容：" + tmp);
        String fileName=tmp.split("\"")[3];
        //getRealPath("/")
        p.write("d:/upload/"+fileName);

    }


}
