package com.xqnode.cloud.feign;

import feign.Feign;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@Configuration
//public class FeignConfig {
//
//    @Bean
//    public Request.Options options() {
//        return new Request.Options(10000, 10000);
//    }
//
//    //重试次数
//    @Bean
//    public Retryer feignRetry() {
//        return new Retryer.Default(100, 1000, 4);
//    }
//
//    //禁用当前配置的hystrix，局部禁用
//    @Bean
//    @Scope("prototype")
//    public Feign.Builder feignBuilder() {
//        return Feign.builder();
//    }
//}
