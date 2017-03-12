package com.czd.service.Impl;

import com.czd.dao.IBaseDao;
import com.czd.service.IBaseService;

import java.util.List;

/**
 * Created by czd on 2017/2/25.
 */

public class BaseService<T> implements IBaseService<T> {

    private IBaseDao<T> baseDao;

    @Override
    public void save(T t) {
        baseDao.save(t);
    }

    @Override
    public void delete(int id) {
        baseDao.delete(id);
    }

    @Override
    public T findById(int id) {
        return (T) baseDao.findById(id);
    }

    @Override
    public List<T> getAll() {
        return baseDao.getAll();
    }

    @Override
    public void update(T t) {
        baseDao.update(t);
    }


    public IBaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(IBaseDao baseDao) {
        this.baseDao = baseDao;
    }
}
