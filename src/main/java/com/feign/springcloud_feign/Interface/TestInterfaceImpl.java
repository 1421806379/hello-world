package com.feign.springcloud_feign.Interface;

import org.springframework.stereotype.Component;

@Component
public class TestInterfaceImpl implements  TestInterface{
    @Override
    public String hello(String hello) {
        return "hello"+hello;
    }

    @Override
    public String test() {
        return "testEEEE";
    }
}
