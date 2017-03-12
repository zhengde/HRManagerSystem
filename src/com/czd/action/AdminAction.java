package com.czd.action;

import com.czd.bean.Admin;
import com.czd.service.IBaseService;
import com.czd.service.Impl.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by czd on 2017/3/2.
 * 管理员登陆注册模块
 */

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
    /**
     * ======================================
     * 程序可以运行时再 试错！！！！！！在bean-action.xml配置也要改
     * ======================================
     */
//    private BaseService<AdminService> aaseService;

    private IBaseService<AdminService> adminService;
    // 封装请求数据,一定要new
    private Admin admin = new Admin();


    /**
     * @return 跳转到login页面
     * @throws Exception
     */
    public String login() throws Exception {
        return LOGIN;
    }

    @Override
    public Admin getModel() {
        return admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setAdminService(IBaseService<AdminService> adminService) {
        this.adminService = adminService;
    }
}
