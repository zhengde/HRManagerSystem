package com.czd.service.Impl;

import com.czd.bean.Admin;
import com.czd.dao.Impl.AdminDao;
import com.czd.service.IAdminService;

/**
 * Created by czd on 2017/2/25.
 */
public class AdminService extends BaseService<AdminService> implements IAdminService{

    private AdminDao adminDao = (AdminDao) getBaseDao();

    @Override
    public Admin findByAdmin(Admin admin) {
        return adminDao.findByAdmin(admin);
    }

}
