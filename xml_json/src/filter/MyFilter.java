package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpServletRequest r = (HttpServletRequest) req;
        HttpServletResponse res = (HttpServletResponse) resp;
        String path = r.getServletPath();

        //如果是特殊路径就放行
        if (path.endsWith("login.jsp") || (path.endsWith("login.do"))) {
            chain.doFilter(req, resp);
            return;
        }

        //判断是否登录过，如果没登录则重定向到login.jsp,登录就放行
        Object o = ((HttpServletRequest) req).getSession().getAttribute("user");
        if (o == null) {
            res.sendRedirect(r.getContextPath() + "/filter/login.jsp");
        } else {
            chain.doFilter(r, res);
        }
    }

    @Override
    public void destroy() {

    }
}
