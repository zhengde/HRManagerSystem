package com.czd.service;

import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */
public interface IBaseService<T> {
    /**
     * 添加
     *
     * @param t
     */
    void save(T t);

    /**
     * 删除
     *
     * @param id
     */
    void delete(int id);

    /**
     * 根据id查询
     *
     * @param id
     */
    T findById(int id);

    /**
     * 查询所有
     */
    List<T> getAll();

    /**
     * 更新
     *
     * @param t
     */
    void update(T t);
}
