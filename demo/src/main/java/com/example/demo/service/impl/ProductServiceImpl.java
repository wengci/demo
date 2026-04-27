package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.exception.BusinessException;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Service：把这个类交给Spring容器管理，后面Controller才能注入它
@Service
public class ProductServiceImpl implements ProductService {

    // 模拟数据库：用Map暂时存一下数据，不用真的连数据库
    private static final Map<Long, Product> PRODUCT_MAP = new HashMap<>();

    // 静态代码块：项目启动时，自动往Map里放一条测试数据
    static {
        Product p1 = new Product();
        p1.setId(1L);
        p1.setProductName("iPhone 16");
        p1.setPrice(new BigDecimal("5999"));
        p1.setStock(100);
        PRODUCT_MAP.put(1L, p1);
    }

    // 实现接口里的 getById 方法
    @Override
    public Product getById(Long id) {
        Product product = PRODUCT_MAP.get(id);
        // 如果查不到商品，直接抛出我们之前写的业务异常
        if (product == null) {
            throw new BusinessException(404, "商品不存在，ID：" + id);
        }
        return product;
    }

    // 实现接口里的 list 方法
    @Override
    public List<Product> list(Integer page, Integer size) {
        // 暂时把Map里所有数据转成List返回，简化分页
        return new ArrayList<>(PRODUCT_MAP.values());
    }

    // 实现接口里的 add 方法
    @Override
    public void add(Product product) {
        // 简单校验：商品名称不能为空
        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            throw new BusinessException("商品名称不能为空");
        }
        // 如果没传ID，就用当前时间戳当ID；传了就用传的
        Long id = product.getId() == null ? System.currentTimeMillis() : product.getId();
        product.setId(id);
        // 存入Map
        PRODUCT_MAP.put(id, product);
    }
}