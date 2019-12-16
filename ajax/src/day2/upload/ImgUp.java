package day2.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/day2/upload/imgUp")
@MultipartConfig
public class ImgUp extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Part p=req.getPart("file");
        String fileName=p.getSubmittedFileName();

        //方案一：在项目目录中建文件夹，放在文件夹中
//        String path=this.getServletContext().getRealPath("/upload");
//        new File(path).mkdirs();
//        path=path+"/"+fileName;
//        p.write(path);
//        //把路径响应到页面的img标签中:/ajax/upload/fileName
//        resp.getWriter().write(req.getContextPath()+"/upload/"+fileName);

        //方案二：写到项目根目录中，要延迟5秒才能看到回显
//        String path=this.getServletContext().getRealPath("/"+fileName);
//        p.write(path);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {}
//        //把路径响应到页面的img标签中:/ajax/upload/fileName
//        resp.getWriter().write(req.getContextPath()+"/"+fileName);

        //方案三：
        String path=this.getServletContext().getRealPath("/"+fileName);
        p.write(path);
        resp.getWriter().write(req.getContextPath()+"/day2/down?name="+fileName);
    }
}
