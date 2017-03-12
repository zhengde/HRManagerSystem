package com.czd.service.Impl;

import com.czd.bean.Dept;
import com.czd.bean.Employee;
import com.czd.dao.Impl.EmployeeDao;
import com.czd.service.IEmployeeService;

import java.util.List;

/**
 * Created by czd on 2017/2/25.
 */
public class EmployeeService extends BaseService<EmployeeService> implements IEmployeeService{

    private EmployeeDao employeeDao = (EmployeeDao) getBaseDao();
    @Override
    public List<Employee> getAll(String empName) {
        return employeeDao.getAll(empName);
    }

    @Override
    public List<Employee> getAll(Dept dept) {
        return employeeDao.getAll(dept);
    }
}



