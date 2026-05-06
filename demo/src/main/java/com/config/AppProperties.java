package com.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ConfigurationProperties 批量层级配置绑定演示
 * prefix = "app"：绑定yml中所有以app开头的配置
 * @Component：交给Spring容器管理
 * @Data：Lombok自动生成Getter/Setter，无需手写
 */
@Data
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    // 对应 app.name
    private String name;

    // 对应 app.version
    private String version;

    // 对应 app.desc
    private String desc;

    // 对应 app.author 嵌套对象（yml中的author层级）
    private Author author;

    // 对应 app.features 数组（yml中的列表自动转为List<String>）
    private List<String> features;

    /**
     * 嵌套类：对应app.author的层级配置
     * 必须为静态内部类，否则Spring无法实例化
     */
    @Data
    public static class Author {
        // 对应 app.author.name
        private String name;
        // 对应 app.author.email
        private String email;
    }
}