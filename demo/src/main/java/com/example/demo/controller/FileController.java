package com.example.demo.controller;

import com.example.demo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j // Lombok注解：自动生成日志对象，用来打印日志
@RestController
@RequestMapping("/api/file") // 接口前缀
public class FileController {

    // 文件保存的路径：就在你项目根目录下创建一个 upload 文件夹
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/upload/";

    // 接口：商品图片上传
    @PostMapping("/upload/product/img")
    public Result<String> uploadProductImg(@RequestParam("file") MultipartFile file) {
        try {
            // 1. 检查文件是否为空
            if (file.isEmpty()) {
                return Result.error("请选择图片");
            }

            // 2. 获取文件后缀（比如 .jpg, .png）
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

            // 3. 生成唯一文件名（UUID防止同名文件覆盖）
            String fileName = UUID.randomUUID() + suffix;

            // 4. 如果 upload 文件夹不存在，就自动创建
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // 5. 把文件保存到本地
            File targetFile = new File(dir, fileName);
            file.transferTo(targetFile);

            // 6. 拼接文件访问地址并返回
            String imgUrl = "/upload/" + fileName;
            log.info("文件上传成功：{}", targetFile.getAbsolutePath());
            return Result.success(imgUrl);

        } catch (Exception e) {
            log.error("商品图片上传失败", e);
            return Result.error("上传失败：" + e.getMessage());
        }
    }
}