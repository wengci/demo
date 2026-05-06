package com.software.springbootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.software.springbootdemo.entity.Product;
import com.software.springbootdemo.entity.ProductImage;
import com.software.springbootdemo.mapper.ProductMapper;
import com.software.springbootdemo.service.ProductImageService;
import com.software.springbootdemo.service.ProductService;
import org.springframework.stereotype.Service; // 👈 必须导入这个
import jakarta.annotation.Resource;
import java.util.List;

@Service // 👈 必须有这个注解！
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
        implements ProductService {

    @Resource
    private ProductImageService productImageService;

    @Override
    public Product getProductWithImages(Long productId) {
        Product product = this.getById(productId);
        if (product == null) {
            return null;
        }
        List<ProductImage> imageList = productImageService.getImagesByProductId(productId);
        product.setImageList(imageList);
        return product;
    }
}