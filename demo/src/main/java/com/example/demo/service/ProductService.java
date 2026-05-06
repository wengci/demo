package com.example.demo.service;

import com.example.demo.entity.Product;
import java.util.List;

public interface ProductService {
    // 根据ID查询商品
    Product getById(Long id);
    // 分页查询商品列表
    List<Product> list(Integer page, Integer size);
    // 新增商品
    void add(Product product);
}