package day4.filter;

import javax.servlet.*;
import java.io.IOException;

public class First implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("first filter begin .....");
        chain.doFilter(req,resp);
        System.out.println("first filter end....");
    }

    public void destroy() {

    }
}
