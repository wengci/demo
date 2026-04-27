package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List; // 关键！

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT user_id as id, username, password FROM \"user\"")
    List<User> findAllUsers();
}