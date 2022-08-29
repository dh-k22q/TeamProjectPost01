package com.example.intermediate.controller;

import com.example.intermediate.controller.response.ResponseDto;
import com.example.intermediate.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@RequiredArgsConstructor
@RestController
public class ImageController {
    private final ImageService imageService;

    //Multipart 타입을 사용해서 클라이언트로부터 파일을 받아옴
    @PostMapping("/upload")
    public ResponseDto<String> uploadFile(@RequestParam("images") MultipartFile multipartFile,
                                          @RequestParam String fileSize) throws IOException {
        return imageService.upload(multipartFile.getInputStream(), multipartFile.getOriginalFilename(), fileSize);
    }
}