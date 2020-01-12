package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@ServletComponentScan("com.demo.spring_boot_filter")

@MapperScan("com.demo.spring_boot_mybatis")
public class Application {
    
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
