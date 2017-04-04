package com.czd.dao.Impl;

import com.czd.dao.IBaseDao;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 * 所有dao的通用操作，希望所有的dao都继承此类
 */
public class BaseDao<T> implements IBaseDao<T> {

    // 当前操作的实际bean类型
    private Class<T> clazz;

    // 获取类名称
    private String className;

    // 反射泛型
    public BaseDao() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        Type types[] = pt.getActualTypeArguments();
        clazz = (Class<T>) types[0];
        className = clazz.getSimpleName();
    }

    //容器注入
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from " + className +" where id=?")
                .setParameter(0, id).executeUpdate();
    }

    @Override
    public T findById(int id) {
        return sessionFactory.getCurrentSession().get(clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from " + className).list();
    }

    @Override
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }
}
