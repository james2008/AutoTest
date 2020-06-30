package com.cn.api.app.listener;

public interface BaseDao<T> {
    /**
     * 根据ID获取实体对象
     *
     * @param id 记录ID
     * @return 实体对象
     */
    public T get(Long id);


    /**
     * 保存实体对象
     *
     * @param entity 对象
     * @return ID
     */
    public T add(T entity);


    /**
     * 更新实体对象
     *
     * @param entity 对象
     */
    public T update(T entity);


    /**
     * 根据ID删除实体对象
     *
     * @param id 记录ID
     */
    public void delete(Long id);
}
