package com.service.impl;

import com.entity.Product;
import com.exception.BusinessException;
import com.service.ProductService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    // 模拟数据库存储
    private static final Map<Long, Product> PRODUCT_MAP = new HashMap<>();

    static {
        // 初始化测试数据
        Product p1 = new Product();
        p1.setId(1L);
        p1.setProductName("iPhone 16");
        p1.setPrice(new BigDecimal("5999"));
        p1.setStock(100);
        PRODUCT_MAP.put(1L, p1);
    }

    @Override
    public Product getById(Long id) {
        Product product = PRODUCT_MAP.get(id);
        // 全局异常：商品不存在直接抛业务异常
        if (product == null) {
            throw new BusinessException(404, "商品不存在，ID：" + id);
        }
        return product;
    }

    @Override
    public List<Product> list(Integer page, Integer size) {
        return new ArrayList<>(PRODUCT_MAP.values());
    }

    @Override
    public void add(Product product) {
        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            throw new BusinessException("商品名称不能为空");
        }
        PRODUCT_MAP.put(product.getId() == null ? System.currentTimeMillis() : product.getId(), product);
    }
}