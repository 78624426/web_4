package day4.el;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/day4/el/s1")
public class S1 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("xmq","西门庆");
        req.getSession().setAttribute("user",new User("admin","123"));

        //数组
        String[]arr = {"你","我","他"};
        req.getSession().setAttribute("arr",arr);

        //集合
        List<String>li=new ArrayList<>();
        li.add("武松");
        li.add("大狼");

        List<User>users=new ArrayList<>();
        users.add(new User("张飞","333"));
        users.add(new User("刘备","111"));
        req.setAttribute("users",users);

        //Map
        Map<String,User> m=new HashMap<>();
        m.put("u1",new User("张飞","333"));
        m.put("u2",new User("刘备","111"));
        req.setAttribute("map",m);

        req.setAttribute("a",10);


        req.getRequestDispatcher("/day4/el/each.jsp").forward(req,resp);
    }
}
