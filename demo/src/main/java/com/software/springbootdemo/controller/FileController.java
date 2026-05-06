package com.software.springbootdemo.controller;

import com.software.springbootdemo.common.Result;
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

    @PostMapping("/upload/product/img")
    public Result<String> uploadProductImg(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return Result.error("请选择图片");
            }
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String fileName = UUID.randomUUID() + suffix;
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();
            file.transferTo(new File(dir, fileName));
            String imgUrl = "/upload/" + fileName;
            return Result.success(imgUrl);
        } catch (Exception e) {
            log.error("商品图片上传失败", e);
            return Result.error("上传失败");
        }
    }
}