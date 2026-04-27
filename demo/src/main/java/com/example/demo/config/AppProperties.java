package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "app") // 绑定 application.yml 中 app 开头的配置
public class AppProperties {
    private String name;
    private String version;
    private Author author;
    private List<String> features;

    @Data
    public static class Author {
        private String name;
        private String email;
    }
}