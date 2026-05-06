package com.software.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.software.springbootdemo.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品 Mapper 接口
 * 继承 BaseMapper<Product>，自动拥有单表 CRUD 能力
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    // 这里什么都不用写，BaseMapper 已经提供了通用方法
}