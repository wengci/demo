package com.software.springbootdemo.controller;

import com.software.springbootdemo.common.Result;
import com.software.springbootdemo.entity.Product;
import com.software.springbootdemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // ===================== 1. 根据ID查询商品（基础接口，必须有） =====================
    @GetMapping("/{id}")
    public Result<Product> getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        return Result.success(product);
    }

    // ===================== 2. 查询全部商品 =====================
    @GetMapping
    public Result<List<Product>> list() {
        List<Product> list = productService.list();
        return Result.success(list);
    }

    // ===================== 3. 新增商品 =====================
    @PostMapping
    public Result<String> add(@RequestBody Product product) {
        productService.save(product);
        return Result.success("新增成功");
    }

    // ===================== 4. 修改商品 =====================
    @PutMapping("/{id}")
    public Result<String> update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.updateById(product);
        return Result.success("修改成功");
    }

    // ===================== 5. 删除商品 =====================
    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id) {
        productService.removeById(id);
        return Result.success("删除成功");
    }

    // ===================== 6. 一对多：查询商品详情（包含图片） =====================
    @GetMapping("/detail/{id}")
    public Result<Product> getProductDetail(@PathVariable Long id) {
        Product product = productService.getProductWithImages(id);
        return Result.success(product);
    }
}