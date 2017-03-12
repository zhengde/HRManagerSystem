package com.czd.action;

import com.czd.bean.Dept;
import com.czd.bean.Employee;
import com.czd.service.IBaseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

/**
 * Created by czd on 2017/3/2.
 * 员工模块
 */
public class EmployeeAction extends ActionSupport{

    /**
     * 封装数据
     */

    /**
     * 注入容器
     */
    private IBaseService<Employee> employeeService;
    private IBaseService<Dept> deptService;

    /**
     * @return 员工展示列表
     * @throws Exception
     */
    public String list() throws Exception {
        // 查询所有员工
        List<Employee> listEmp = employeeService.getAll();
        // 将所有员工数据保存到request中
        Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
        request.put("listEmp",listEmp);
        return "list";
    }

    public void setEmployeeService(IBaseService<Employee> employeeService) {
        this.employeeService = employeeService;
    }

    public void setDeptService(IBaseService<Dept> deptService) {
        this.deptService = deptService;
    }
}
