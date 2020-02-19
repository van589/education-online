package com.van589.mooc.web.admin.service;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseRoleEntity;

import java.util.Map;

public interface UserService<T extends BaseRoleEntity> {

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
     * @return
     */
    public int count();

    /**
     * 保存信息
     * @param entity
     * @return
     */
    public BaseResult save(T entity);
}
