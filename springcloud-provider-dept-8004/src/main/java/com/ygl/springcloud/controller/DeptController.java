package com.ygl.springcloud.controller;

import com.ygl.springcloud.pojo.Dept;
import com.ygl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //增加
    @PostMapping("/addDept")
    public Boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    //根据id进行查询
    @GetMapping("/queryById")
    public Dept queryById(Integer id){
        return deptService.queryById(id);
    }
    //查询所有
    @GetMapping("/queryAll")
    public List<Dept> queryAll(){
        return deptService.queruAll();
    }

    //注册进来的微服务~获取一些信息~
    @GetMapping("/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>"+services);
        //得到一个具体的微服务信息，通过具体的微服务id,applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance s: instances) {
            System.out.println(s.getHost()+"\t"+
            s.getPort()+"\t"+
            s.getUri()+"\t"+
            s.getServiceId()
            );
        }
        return this.client;
    }

}
