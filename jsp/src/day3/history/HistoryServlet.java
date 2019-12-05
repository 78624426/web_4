package day3.history;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HistoryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        //获取产品相关的cookie值
        Cookie[]arr=req.getCookies();
        Cookie c=getCookie(arr,"product");
        if(c==null){
            c=new Cookie("product",id);
            resp.addCookie(c);
        }else{
            String v=c.getValue();//1,3
            if(!v.contains(id)){//如果v中不包含该id,则追加
                c.setValue(v+","+id);
                resp.addCookie(c);
            }
        }
        req.getSession().setAttribute("msg",id+"号商品已加入历史记录");
        resp.sendRedirect(req.getContextPath()+"/day3/history/product.jsp");
    }


    Cookie getCookie(Cookie[]arr,String name){
        if(arr==null){
            return null;
        }
        for(Cookie c:arr){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
}
