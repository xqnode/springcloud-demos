package com.xqnode.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
@RefreshScope
public class ServiceController {

    @Value("${location}")
    private String location;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/location")
    public String showLocation() {
        return location;
    }
}
