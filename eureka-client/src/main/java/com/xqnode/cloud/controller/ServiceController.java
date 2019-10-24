package com.xqnode.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/service")
@RefreshScope
public class ServiceController {

    @Value("${location:合肥}")
    private String location;

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/location")
    public String showLocation() {
        return location;
    }

    @GetMapping("/port")
    public String port() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(5);
        return String.format("now call port: %s", port);
    }

    @PostMapping("/file")
    public String file(@RequestPart MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        System.out.println("收到上传文件:" + file.getName() + " 文件大小: " + bytes.length);
        return "success";
    }

    @GetMapping("/file")
    public void getFile(HttpServletResponse response) throws IOException {
        File file = new File("D:/download/wlr.mp3");
        try (FileInputStream inputStream = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            inputStream.read(data);
            OutputStream stream = response.getOutputStream();
            stream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
