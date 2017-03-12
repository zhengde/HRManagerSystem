package com.czd.dao.Impl;

import com.czd.bean.Dept;
import com.czd.bean.Employee;
import com.czd.dao.IEmployeeDao;

import java.util.List;

/**
 * Created by czd on 2017/2/25.
 */
public class EmployeeDao extends BaseDao<Employee> implements IEmployeeDao {

    /**
     * @param empName 员工姓名
     * @return 根据empName查询所有符合该名字的员工
     */
    @Override
    public List<Employee> getAll(String empName) {
        return getSessionFactory().getCurrentSession()
                .createQuery("select e from Employee e where e.name like ?")
                .setParameter(0, "%" + empName + "%")
                .list();
    }

    /**
     * @param dept 员工部门
     * @return 根据dept查询所有该部门下的员工
     */
    @Override
    public List<Employee> getAll(Dept dept) {
        return getSessionFactory().getCurrentSession()
                .createQuery("select e from Employee e where e.dept like ?")
                .setParameter(0, "%" + dept.getName() + "%")
                .list();
    }
}
