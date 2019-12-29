package com.demo.spring_boot_interceptor;

import com.demo.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/error")
@RestController
public class ErrorController {
    @RequestMapping("/message")
    public Result error(){
        return new Result(false,"该路径有问题");
    }

}
