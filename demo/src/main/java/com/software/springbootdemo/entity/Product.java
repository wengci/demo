package com.software.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@TableName("product")
public class Product {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String productName;
    private BigDecimal price;
    private Integer stock;
    private String imgUrl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    /**
     * 一对多：一个商品对应多张图片
     * exist = false 表示该字段不是数据库列，仅用于 Java 层接收关联数据
     */
    @TableField(exist = false)
    private List<ProductImage> imageList;
}