package com.ygl.springcloud.controller;

import com.ygl.springcloud.pojo.Dept;
import com.ygl.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ygl
 * @description
 * @date 2020/12/10 20:25
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService service = null;


    @RequestMapping("/consumer/dept/addDept")
    public boolean addDept(@RequestBody Dept dept){
        return this.service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/queryById")
    public Dept queryById(Integer id){
        return this.service.queryById(id);
    }
    @RequestMapping("/consumer/dept/queryAll")
    public List<Dept> queryAll(){
        return this.service.queryAll();
    }
}
