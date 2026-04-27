package com.example.demo.common;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code; // 状态码：200成功，400/404业务错误，500系统错误
    private String msg;   // 提示信息
    private T data;       // 返回数据

    // 成功：无数据
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }

    // 成功：带数据
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    // 失败：默认错误码
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setCode(400);
        result.setMsg(msg);
        return result;
    }

    // 失败：自定义错误码
    public static <T> Result<T> error(Integer code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}