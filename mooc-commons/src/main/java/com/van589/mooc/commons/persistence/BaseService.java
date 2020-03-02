package com.van589.mooc.commons.persistence;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;

import java.util.Map;

/**
 * 所有 Service 层的基类
 *
 * @param <T>
 */
public interface BaseService<T extends BaseEntity> {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    public PageInfo<T> page(Map<String, Object> params);

    /**
     * 查询分页笔数
     *
     * @param entity
     * @return
     */
    public int count(T entity);

    /**
     * 查询单条信息
     *
     * @param id
     * @return
     */
    public T getById(String id);

    /**
     * 保存信息
     *
     * @param entity
     * @return
     */
    public BaseResult save(T entity);

    /**
     * 删除一条或多条信息
     *
     * @param ids
     */
    public void deleteMulti(String[] ids);
}
