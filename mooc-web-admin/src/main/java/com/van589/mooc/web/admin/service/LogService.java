package com.van589.mooc.web.admin.service;

import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.domain.Log;

import java.util.Map;

public interface LogService<T extends BaseEntity> {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    public PageInfo<T> page(Map<String, Object> params);
}
