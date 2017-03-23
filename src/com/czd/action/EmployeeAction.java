package com.czd.action;

import com.czd.bean.Dept;
import com.czd.bean.Employee;
import com.czd.service.IBaseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.interceptor.RequestAware;

import java.util.List;
import java.util.Map;

/**
 * Created by czd on 2017/3/2.
 * 员工模块
 */
public class EmployeeAction extends ActionSupport implements RequestAware, ModelDriven<Employee> {

    /**
     * 封装数据
     */
    private Employee employee = new Employee();
    private int deptId;
    /**
     * 注入容器
     */
    private IBaseService<Employee> employeeService;
    private IBaseService<Dept> deptService;

    /**
     * @return 员工展示列表
     */
    public String list() {
        // 查询所有员工
        List<Employee> listEmp = employeeService.getAll();
        // 将所有员工数据保存到request中
//        Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
        request.put("listEmp", listEmp);
        return "list";
    }

    /**
     * 进入添加员工数据的界面
     */
    public String addView() {
        // 查询所有部门信息，再保存到request
        List<Dept> deptList = deptService.getAll();
        request.put("deptList", deptList);
        return "add";
    }

    /**
     * 保存员工数据，并跳转到展示界面
     */
    public String save() {
        // 根据deptId查询Dept
        Dept dept = deptService.findById(deptId);
        // 设置到Employee对象中
        employee.setDept(dept);
        employeeService.save(employee);
//        return "list";
        return "listAction";
    }

    /**
     * 进入更新员工数据页面
     */
    public String updateView() {
        // 获取要修改员工记录的id
        int id = employee.getId();
        Employee emp = employeeService.findById(id);// 关闭懒加载，有dept值，所以deptId有值
        // 查询所有部门
        List<Dept> deptList = deptService.getAll();
        // 保存Employee和Dept对象
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.pop();
        vs.push(emp);

        request.put("deptList",deptList);

        return "update";
    }

    /**
     * 保存更新后的员工数据，并跳转到展示界面
     */
    public String update(){
        // 根据部门id查询修改后的部门对象，之后再设置到员工属性中
        Dept dept = deptService.findById(deptId);
        employee.setDept(dept);
        // 更新员工
        employeeService.update(employee);
        return "listAction";
    }

    /**
     * 删除一个员工数据
     */
    public String delete(){
        int id = employee.getId();
        employeeService.delete(id);
        return "listAction";
    }

    private Map<String, Object> request;

    /**
     * RequestAware接口的方法
     * 作用：接收框架运行时候传入的代表request对象的map
     */
    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    public void setEmployeeService(IBaseService<Employee> employeeService) {
        this.employeeService = employeeService;
    }

    public void setDeptService(IBaseService<Dept> deptService) {
        this.deptService = deptService;
    }

    public IBaseService<Dept> getDeptService() {
        return deptService;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public IBaseService<Employee> getEmployeeService() {
        return employeeService;
    }

    /**
     * 返回实例化后的对象
     *
     * @return
     */
    @Override
    public Employee getModel() {
        return employee;
    }

}
