package com.xqnode.cloud.controller;

import com.xqnode.cloud.feign.MyFeignClient;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/feign")
public class ServiceController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    MyFeignClient myFeignClient;

    @GetMapping("/call")
    public String hello() {
        return myFeignClient.callPort().body().toString();
    }

    @PostMapping("/file")
    public String file(@RequestPart MultipartFile file) {
        return myFeignClient.file(file).body().toString();
    }

    @GetMapping("/file")
    public void getFile(HttpServletResponse response) throws IOException {
        Response file = myFeignClient.getFile();
        Response.Body body = file.body();
        OutputStream outStream;
        try (InputStream fileInputStream = body.asInputStream()) {
            byte[] b = new byte[fileInputStream.available()];
            fileInputStream.read(b);
            outStream = response.getOutputStream();
            outStream.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
