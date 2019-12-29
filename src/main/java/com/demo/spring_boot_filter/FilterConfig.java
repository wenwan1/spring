package com.demo.spring_boot_filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){


        /**
         * registration.setFilter(Filter filter)：设置我们自定义Filter对象。
         *
         * registration.setUrlPatterns(Collection<String> urlPatterns)：设置自定义Filter需要拦截的URL的集合。
         *
         * registration.setName(String name)： 设置自定义Filter名称。
         *
         * registration.setOrder(int order)：设置自定义Filter拦截顺序。
         */

        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        List<String> urlList=new ArrayList<>();
        urlList.add("/*");
        registrationBean.setUrlPatterns(urlList);
        registrationBean.setName("UrlFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
