package com.buzhiming.controller;

import com.buzhiming.VO.ResultVO;
import com.buzhiming.enums.CodeEnum;
import com.buzhiming.provider.UCloudProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    private UCloudProvider uCloudProvider;

    @RequestMapping("/upload")
    public ResultVO<String> upload(@RequestParam("file")MultipartFile file) throws IOException {
        System.out.println(file.getContentType());
        String upload = uCloudProvider.upload(file.getInputStream(), file.getContentType(),file.getOriginalFilename());
        return new ResultVO<>(CodeEnum.UPLOADE_SUCCESS.id,CodeEnum.UPLOADE_SUCCESS.message,upload);
    }
}
