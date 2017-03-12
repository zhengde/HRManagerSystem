package com.czd.service.Impl;

import com.czd.dao.Impl.DeptDao;
import com.czd.service.IDeptService;

/**
 * Created by czd on 2017/2/25.
 */
public class DeptService extends BaseService<DeptService> implements IDeptService{
    private DeptDao deptDao = (DeptDao) getBaseDao();
}
