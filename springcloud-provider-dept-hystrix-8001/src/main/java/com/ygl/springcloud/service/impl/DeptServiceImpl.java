package com.ygl.springcloud.service.impl;


import com.ygl.springcloud.pojo.Dept;

import com.ygl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ygl.springcloud.dao.DeptDao;

import java.util.List;

/**
 * @author ygl
 * @description
 * @date 2020/12/10 19:36
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Integer id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queruAll() {
        return deptDao.queruAll();
    }
}
