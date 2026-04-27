package com.example.demo.service;

import com.example.demo.entity.Product;
import java.util.List;

// 这就是接口：只定义功能方法名，不写具体代码
public interface ProductService {
    // 方法1：根据ID查询商品
    Product getById(Long id);

    // 方法2：分页查询商品列表
    List<Product> list(Integer page, Integer size);

    // 方法3：新增商品
    void add(Product product);
}