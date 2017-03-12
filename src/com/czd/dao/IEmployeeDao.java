package com.czd.dao;

import com.czd.bean.Dept;
import com.czd.bean.Employee;

import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 * 员工模块dao接口设计
 */
public interface IEmployeeDao/* extends IBaseDao*/ {

    List<Employee> getAll(String empName);
    List<Employee> getAll(Dept dept);

}
