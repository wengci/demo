package com.software.springbootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.software.springbootdemo.entity.Product;

public interface ProductService extends IService<Product> { // 👈 必须继承
    Product getProductWithImages(Long productId);
}