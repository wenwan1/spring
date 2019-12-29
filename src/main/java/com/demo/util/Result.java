package com.demo.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result {
    private Object content;
    private boolean status;
    private String message;

    public Result(boolean status,String message){
        this.message=message;
        this.status=status;
    }

    public Result(Object content, boolean status, String message) {
        this.content=content;
        this.status=status;
        this.message=message;
    }
}
