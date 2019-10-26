package com.xqnode.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xqnode.cloud.RestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon")
public class ServiceController {
    @Autowired
    RestServiceImpl restService;


    @GetMapping("/call")
    public String callPort() {
        return restService.callPort();
    }
}
