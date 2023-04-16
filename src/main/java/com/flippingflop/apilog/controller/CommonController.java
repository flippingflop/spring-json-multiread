package com.flippingflop.apilog.controller;

import com.flippingflop.apilog.dto.HelloWorldRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CommonController {

    @PostMapping("/api/hello-world")
    public ResponseEntity<String> helloWorldApi(@RequestBody HelloWorldRequest req) {
        return ResponseEntity.ok("request received.");
    }

    @PostMapping(value = "/api/hello-world/multipart", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> helloWorldMultipart(@RequestPart HelloWorldRequest req, @RequestPart MultipartFile multipartFile) {
        return ResponseEntity.ok("multipart request received.");
    }

}
