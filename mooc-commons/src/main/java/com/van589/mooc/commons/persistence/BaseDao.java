package com.van589.mooc.commons.persistence;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

/**
 * 所有 DAO 层的基类
 *
 * @param <T>
 */
public interface BaseDao<T extends BaseEntity> extends Mapper<T>, MySqlMapper<T> {

    /**
     * 分页查询
     *
     * @param params，需要两个参数，start/记录开始的位置 length/每页记录数
     * @return
     */
    List<T> page(Map<String, Object> params);

    /**
     * 查询总笔数
     *
     * @param entity
     * @return
     */
    int count(T entity);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    public T selectById(String id);

    /**
     * 更新单条信息
     *
     * @param entity
     */
    void update(T entity);
}
