package com.work.controller;

import com.work.pojo.Result;
import com.work.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/upload")
public class UploadController {
//    @PostMapping
//    public Result upload(String username, Integer age, MultipartFile image)throws Exception{
//        String originalFilename = image.getOriginalFilename();
//        int index = originalFilename.lastIndexOf(".");
//        String extendName = originalFilename.substring(index);
//        String FileName = "D:\\webcontian\\"+ UUID.randomUUID().toString()+extendName;
//        image.transferTo(new File(FileName));
//
//        log.info("{}",image);
//        return Result.success(username);
//    }

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传"+image.getOriginalFilename());
        //调用阿里云oos工具类
        String url = aliOSSUtils.upload(image);
        return Result.success(url);
    }
}
