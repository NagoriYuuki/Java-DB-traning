package com.yuuuki.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int code;
    private String message;
    private Object data;

    public static Result success(String message){
        return new Result(200, message, null);
    }

    public static  Result success(String message, Object data){
        return new Result(200, message, data);
    }

    public static Result fail(String message){
        return new Result(500, message, null);
    }

}
