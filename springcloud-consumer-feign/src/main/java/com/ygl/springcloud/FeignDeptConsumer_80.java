package com.ygl.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author ygl
 * @description 启动类
 * @date 2020/12/10 19:47
 */
@SpringBootApplication
@EnableEurekaClient   //开启eureka
@EnableFeignClients(basePackages = {"com.ygl.springcloud"})   //开启feign
@ComponentScan("com.ygl.springcloud")
public class FeignDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class,args);
    }
}
