package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    // 查询所有用户
    List<User> findAllUsers();
}