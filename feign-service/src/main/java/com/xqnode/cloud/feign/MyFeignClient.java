package com.xqnode.cloud.feign;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


// feign内部实现了负载均衡策略
@FeignClient(/*url = "http://localhost:8001",*/value = "eureka-client", /*fallback = HystrixFallbackConfig.class,*/
        fallbackFactory = FeignFallbackFactory.class/*,configuration = FeignConfig.class*/)
public interface MyFeignClient {
    @GetMapping("/service/port")
    Response callPort();

    // consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
    //produces:    指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
    @PostMapping(value = "/service/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Response file(@RequestPart MultipartFile file);

    @GetMapping(value = "/service/file")
    Response getFile();
}
