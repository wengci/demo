package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("\"user\"") // 关键！user是关键字必须加引号
public class User {

    @TableId(value = "user_id", type = IdType.AUTO) // 正确主键注解！
    private Integer id;

    private String username;
    private String password;
}