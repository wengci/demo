package com.example.demo.entity;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private String productName;
    private BigDecimal price;
    private Integer stock;
    private String imgUrl; // 商品图片地址（对接文件上传）
}