package com.software.springbootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.software.springbootdemo.entity.ProductImage;
import java.util.List;

public interface ProductImageService extends IService<ProductImage> { // 👈 必须继承
    List<ProductImage> getImagesByProductId(Long productId);
}