package day2.upload;

import day1.ajax.entity.Result;
import mvc.annotation.RequestMapping;
import mvc.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

@RequestMapping("/day2/upload")
public class MvcUp {
    @RequestMapping("/up")
    @ResponseBody
    public Result up(HttpServletRequest req, HttpServletResponse resp, Collection<Part> parts) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        Result rs=new Result();
        for(Part p:parts){
            String tmp=p.getHeader("Content-Disposition");
            String type=p.getContentType();
            System.out.println("tmp:"+tmp+",type:"+type);
            if(type!=null){
                String name=tmp.split("\"")[3];
                p.write("d:/"+name);
                rs.setInfo("文件上传成功");
            }else{
                rs.setInfo("没上传文件");
            }
        }
        return rs;
    }
}
