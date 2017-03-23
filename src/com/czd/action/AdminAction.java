package com.czd.action;

import com.czd.bean.Admin;
import com.czd.service.IAdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by czd on 2017/3/2.
 * 管理员登陆注册模块
 */

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

    private IAdminService adminService;

    // 封装请求数据,一定要new
    private Admin admin = new Admin();


    /**
     * @return 登录验证
     * @throws Exception
     */
    public String login() throws Exception {
        Admin adminInfo = adminService.findByAdmin(admin);//admind的id为null，findByAdmin没有执行
        System.out.println("==============");//
            // 验证
            if (adminInfo == null) {
                // 登录失败
                return "loginFailed";
            } else {
                // 登录成功
                ActionContext.getContext().getSession().put("adminInfo", adminInfo);
                return LOGIN;

        }
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

    public IAdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }
}
