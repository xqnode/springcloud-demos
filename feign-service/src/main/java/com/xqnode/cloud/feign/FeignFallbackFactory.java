package com.xqnode.cloud.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignFallbackFactory implements FallbackFactory<MyFeignClient> {
    @Override
    public MyFeignClient create(Throwable throwable) {
        System.out.println("错误信息：" + throwable.getMessage());
        return null;
    }
}
