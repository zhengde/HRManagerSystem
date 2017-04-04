package com.czd.service.Impl;

import com.czd.bean.Admin;
import com.czd.dao.Impl.AdminDao;
import com.czd.service.IAdminService;

/**
 * Created by czd on 2017/2/25.
 */
public class AdminService extends BaseService<Admin> implements IAdminService {

    private AdminDao adminDao;

    @Override
    public Admin findByAdmin(Admin admin) {
        adminDao = (AdminDao) getBaseDao();
        return adminDao.findByAdmin(admin);
    }

}
