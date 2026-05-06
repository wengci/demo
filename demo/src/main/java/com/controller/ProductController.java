package com.controller;

import com.common.Result;
import com.entity.Product;
import com.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor // 构造器注入（Spring官方推荐）
public class ProductController {

    private final ProductService productService;

    /**
     * 1. @PathVariable：路径参数，根据ID查询商品
     */
    @GetMapping("/{id}")
    public Result<Product> getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        return Result.success(product);
    }

    /**
     * 2. @RequestParam：查询参数，分页列表
     */
    @GetMapping("/list")
    public Result<List<Product>> list(
            @RequestParam Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        List<Product> list = productService.list(page, size);
        return Result.success(list);
    }

    /**
     * 3. @RequestBody：请求体，新增商品
     */
    @PostMapping
    public Result<String> add(@RequestBody Product product) {
        productService.add(product);
        return Result.success("新增商品成功");
    }
}