package com.ygl.springcloud.service;

import com.ygl.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ygl
 * @description
 * @date 2020/12/12 17:13
 */
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT" , fallbackFactory=DeptClientServiceFallbackFactory.class)
//@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")  //此注解是开启feign;value是feign组件访问服务名称
public interface DeptClientService {
    @GetMapping("/dept/queryById")
    public Dept queryById(@RequestParam("id") Integer id);
    @GetMapping("/dept/queryAll")
    public List<Dept> queryAll();
    @PostMapping("/dept/addDept")
    public boolean addDept(Dept dept);
}
