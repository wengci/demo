package com.controller;

import com.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/file")
public class FileController {

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/upload/";

    /**
     * 商品图片上传
     */
    @PostMapping("/upload/product/img")
    public Result<String> uploadProductImg(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return Result.error("请选择图片");
            }
            // 生成唯一文件名
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String fileName = UUID.randomUUID() + suffix;
            // 创建目录
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();
            // 保存文件
            file.transferTo(new File(dir, fileName));
            // 返回可访问地址
            String imgUrl = "/upload/" + fileName;
            return Result.success(imgUrl);
        } catch (Exception e) {
            log.error("商品图片上传失败", e);
            return Result.error("上传失败");
        }
    }
}