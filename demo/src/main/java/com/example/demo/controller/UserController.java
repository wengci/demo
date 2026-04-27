package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")  // 接口根路径：http://localhost:8080/user
public class UserController {

    // 注入UserService
    @Autowired
    private UserService userService;

    // 查询所有用户接口：GET http://localhost:8080/user/list
    @GetMapping("/list")
    public Result<List<User>> findAllUsers() {
        List<User> userList = userService.findAllUsers();
        // 返回统一格式的成功结果
        return Result.success(userList);
    }
}