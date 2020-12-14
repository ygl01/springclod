package com.ygl.springcloud.controller;

import com.ygl.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    //消费者不应该有service层
    //RestTemplate...供我们直接调用即可了，注册到spring中
    //(url,实体:map，Class<T> responseType)
    @Autowired
    @Qualifier(value = "abc")
    private RestTemplate restTemplate; //提供多种便捷访问远程http的方法，简单的restful模板
    //前缀
    //private static final String REST_URL_PREFIX = "http://localhost:8001/dept";
    //Ribbon。我们这里的地址应该是一个变量，通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @Autowired
    private DiscoveryClient client;

//    private static final String REST_URL_PREFIX = "http://eureka7001.com:7001/eureka";

    @RequestMapping("/consumer/dept/addDept")
    public boolean addDept(@RequestBody Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/addDept",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/queryById")
    public Dept queryById(Integer id){
        String a=REST_URL_PREFIX+"/queryById?id="+id;
        System.out.println("AAA："+a);
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/queryById?id="+id,Dept.class);
    }
    @RequestMapping("/services")
    public Object services() {
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
    @RequestMapping("/consumer/dept/queryAll")
    public List<Dept> queryAll(){
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        System.out.println("测试地址："+"http://"+host+":"+port+"/dept/queryAll");
        String s = REST_URL_PREFIX+"/dept/queryAll";
        System.out.println("进来了！");
        System.out.println("地址："+s);
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/queryAll",List.class);
    }
}
