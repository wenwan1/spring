package com.demo.spring_boot_filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName="webFilter",urlPatterns = "/*")
public class WebFilterTest implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("来了，老弟2");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("LogFilter2 Execute cost=" + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {
        System.out.println("过滤器2销毁");
    }
}
