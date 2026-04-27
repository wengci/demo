package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 声明这是一个Web接口类，所有方法返回JSON
@RequestMapping("/product") // 接口的统一前缀：http://localhost:9090/product
@RequiredArgsConstructor // Lombok注解：自动生成构造器，用来注入Service
public class ProductController {

    // 注入Service：不用写new，Spring自动给我们
    private final ProductService productService;

    // 接口1：GET请求，路径参数，根据ID查商品
    // 访问地址：http://localhost:9090/product/1
    @GetMapping("/{id}")
    public Result<Product> getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        return Result.success(product);
    }

    // 接口2：GET请求，查询参数，商品列表
    // 访问地址：http://localhost:9090/product/list?page=1
    @GetMapping("/list")
    public Result<List<Product>> list(
            @RequestParam Integer page, // 必须传的参数
            @RequestParam(defaultValue = "10") Integer size // 非必须，不传默认是10
    ) {
        List<Product> list = productService.list(page, size);
        return Result.success(list);
    }

    // 接口3：POST请求，请求体(JSON)，新增商品
    // 访问地址：http://localhost:9090/product
    @PostMapping
    public Result<String> add(@RequestBody Product product) {
        productService.add(product);
        return Result.success("新增商品成功");
    }
}