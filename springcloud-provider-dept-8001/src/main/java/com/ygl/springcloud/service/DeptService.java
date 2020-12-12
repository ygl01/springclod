package com.ygl.springcloud.service;

import com.ygl.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author ygl
 * @description
 * @date 2020/12/10 19:33
 */
public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept queryById(Integer id);
    public List<Dept> queruAll();
}
