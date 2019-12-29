package com.demo.spring_boot_filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *自定义过滤器
 */
public class MyFilter implements Filter {

  //  private static final Logger logger= LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("来了，老弟1");
    }


    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        //此处有URI和URL两个知识点
        String requestURI=httpServletRequest.getRequestURI();
        StringBuffer requestURL=httpServletRequest.getRequestURL();
        System.out.println("requestURI:"+requestURI+","+"requestURL:"+requestURL);
        filterChain.doFilter(httpServletRequest,servletResponse);
    }

    /**
     * 销毁过滤器
     */
    @Override
    public void destroy() {
        System.out.println("过滤器1销毁");

    }
}
