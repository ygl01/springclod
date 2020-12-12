package com.ygl.springcloud.dao;

import com.ygl.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ygl
 * @description
 * @date 2020/12/10 17:44
 */
@Mapper
@Repository //在service注入DepaDao的时候不会报红线
public interface DeptDao {
    public boolean addDept(Dept dept);
    public Dept queryById(Integer id);
    public List<Dept> queruAll();
}
