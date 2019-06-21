package com.feign.springcloud_feign.controller;


import com.feign.springcloud_feign.Interface.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
public class TestController {

    @Autowired
    TestInterface testInterface;

    @RequestMapping("/hello")
    public String hello(@RequestParam("hello") String hello){
        return testInterface.hello(hello);
    }

    @RequestMapping("/test")
    public String test(){
        long startTime = System.currentTimeMillis();    //获取开始时间
        String t=testInterface.test();   //测试的代码段
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("test程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        return t;
    }


    @RequestMapping("/test2")
    public Callable<String> test2(){
        Callable<String> callable= new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                long startTime = System.currentTimeMillis();    //获取开始时间
                String t=testInterface.test();   //测试的代码段
                long endTime = System.currentTimeMillis();    //获取结束时间
                System.out.println("test2程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
                return t;
            }
        };
        return callable;
    }
}
