package com.example.demo;

import com.example.demo.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

// 核心注解
@SpringBootApplication
// 开启配置绑定，绑定我们的AppProperties类
@EnableConfigurationProperties(AppProperties.class)
public class SpringbootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }
}