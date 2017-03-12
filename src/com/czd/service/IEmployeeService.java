package com.czd.service;

import com.czd.bean.Dept;
import com.czd.bean.Employee;

import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 * 员工模块业务逻辑层接口
 */
public interface IEmployeeService  {
    public List<Employee> getAll(String empName);
    public List<Employee> getAll(Dept dept);

}
