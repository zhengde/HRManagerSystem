package com.czd.dao.Impl;

import com.czd.bean.Admin;
import com.czd.dao.IAdminDao;

/**
 * Created by Administrator on 2017/2/25.
 *
 */
public class AdminDao extends BaseDao<Admin> implements IAdminDao {

    @Override
    public Admin findByAdmin(Admin admin) {
        System.out.println("findByAdmin");
        return (Admin) getSessionFactory().getCurrentSession()
                .createQuery("select a from Admin a where a.name=? and a.password=?")
                .setParameter(0, admin.getName())
                .setParameter(1, admin.getPassword())
                .uniqueResult();
    }

}