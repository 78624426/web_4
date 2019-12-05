package day3.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {
    FilterConfig cfg;
    /*启动服务器时会实例化过滤器，在实例化后就会执行init方法，且只会执行一次*/
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init方法被执行了....");
        this.cfg=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("myfilter的dofilter执行了...");
        String encode=cfg.getInitParameter("encode");
        req.setCharacterEncoding(encode);
        resp.setContentType("text/html;charset="+encode);
        HttpServletRequest r= (HttpServletRequest) req;
        String name= (String) r.getSession().getAttribute("name");
        if(name!=null){//成功登录就放行
            chain.doFilter(req,resp);
        }else{
            req.getRequestDispatcher("/day3/filter/login.jsp").forward(req,resp);
        }

    }

    @Override
    public void destroy() {

    }
}
