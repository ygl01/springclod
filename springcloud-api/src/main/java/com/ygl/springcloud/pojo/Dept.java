package com.ygl.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ygl
 * @description
 * @date 2020/12/10 16:55
 */
@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
/*
 链式写法中的chain 默认是false
 在false时，我们会
    dept = new Dept();
    dept.setDeptno(11);
    dept.setDname("张三");
 当开启后
    可以直接dept.setDeptno(11).setDname("张三");

 */
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;

    //这个数据数存在那个数据库的字段 ~ 微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
