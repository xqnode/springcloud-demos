package com.xqnode.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call")
    public String callHello() {
        return restTemplate.getForObject("http://user-service/user/hello", String.class);
    }
}
