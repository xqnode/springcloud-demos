package com.xqnode.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceImpl {

    @Autowired
    RestTemplate restTemplate;

    //使用断路器
    @HystrixCommand(fallbackMethod = "errorMethod")
    public String callPort() {
        String url = "http://eureka-client/service/port";
        return restTemplate.getForObject(url, String.class);
    }

    //当服务不可用时调用此方法返回
    public String errorMethod(Throwable throwable) {
        System.err.println(throwable.getMessage());
        return "This is a error page";
    }
}
