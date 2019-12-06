package day4.filter;

import javax.servlet.*;
import java.io.IOException;

public class Second implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("sencodFilter beign ....");
        chain.doFilter(req,resp);
        System.out.println("secondFilter end....");
    }

    @Override
    public void destroy() {

    }
}
