package com.ygl.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ygl
 * @description
 * @date 2020/12/10 20:32
 */
@Configuration
public class ConfigBean { //@Configuration ---> 类似于spring中的  application.xml
    //配置负载均衡实现RestTemplate
    @Bean(name = "abc")
    @LoadBalanced //Ribbon 负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
