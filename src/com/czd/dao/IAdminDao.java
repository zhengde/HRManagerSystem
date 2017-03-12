package com.czd.dao;

import com.czd.bean.Admin;

/**
 * Created by Administrator on 2017/2/25.
 * 管理员模块dao接口
 */

public interface IAdminDao{

    /**
     * 查询
     * @param admin 管理对象
     */
    Admin findByAdmin(Admin admin);

}
