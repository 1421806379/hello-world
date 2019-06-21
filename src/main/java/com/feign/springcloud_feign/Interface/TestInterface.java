package com.feign.springcloud_feign.Interface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(value = "hello",fallback =TestInterfaceImpl.class )
public interface TestInterface {

    @RequestMapping(value = "/hello")
    String hello(@RequestParam("hello") String hello);

    @RequestMapping(value = "/test")
    String test();
}
