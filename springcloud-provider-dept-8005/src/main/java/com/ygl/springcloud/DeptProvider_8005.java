package com.ygl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ygl
 * @description 启动类
 * @date 2020/12/10 19:47
 */
@SpringBootApplication
@EnableEurekaClient //服务在启动后自动注册到Eureka中
@EnableDiscoveryClient //服务发现    发现自己
public class DeptProvider_8005 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8005.class,args);
    }
}
