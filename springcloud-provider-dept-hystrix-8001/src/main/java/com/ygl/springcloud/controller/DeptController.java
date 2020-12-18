package com.ygl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ygl.springcloud.pojo.Dept;

import com.ygl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author ygl
 * @description
 * @date 2020/12/10 19:38
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    //获取一些配置的信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;


    //根据id进行查询
    @GetMapping("/queryById")
    //出现hystrix时返回调用的方法
    @HystrixCommand(fallbackMethod = "queryHystrixById")
    public Dept queryById(Integer id){
        System.out.println("我来了");
        Dept dept = deptService.queryById(id);
        System.out.println("查询的值为："+dept);
        if (dept == null){
            throw new RuntimeException("id===>"+id+"，该id不存在，或者信息无法找到~~~");
        }

        return dept;
    }

    //出现问题，备选方法
    public Dept queryHystrixById(Integer id){
        return new Dept()
                .setDeptno(id)
                .setDname("所查的id"+id+"不存在，信息为null")
                .setDb_source("没有这个数据库");
    }

}
