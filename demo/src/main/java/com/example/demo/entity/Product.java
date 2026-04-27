package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private String productName;
    private BigDecimal price;
    private Integer stock;
    private String imgUrl; // 商品图片地址
}