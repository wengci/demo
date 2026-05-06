package com.software.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.software.springbootdemo.entity.ProductImage;
import com.software.springbootdemo.mapper.ProductImageMapper;
import com.software.springbootdemo.service.ProductImageService;
import org.springframework.stereotype.Service; // 👈 必须导入
import java.util.List;

@Service // 👈 必须有这个注解！
public class ProductImageServiceImpl extends ServiceImpl<ProductImageMapper, ProductImage>
        implements ProductImageService {

    @Override
    public List<ProductImage> getImagesByProductId(Long productId) {
        LambdaQueryWrapper<ProductImage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProductImage::getProductId, productId);
        wrapper.orderByAsc(ProductImage::getSort);
        return this.list(wrapper);
    }
}