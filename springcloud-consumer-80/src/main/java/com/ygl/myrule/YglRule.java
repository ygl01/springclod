package com.ygl.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ygl
 * @description
 * @date 2020/12/12 16:03
 */
@Configuration
public class YglRule {

    @Bean
    public IRule myRule(){
        return new YglRandomRule(); //默认采用轮询算法，现在我们采取自己编写的算法
    }
}
