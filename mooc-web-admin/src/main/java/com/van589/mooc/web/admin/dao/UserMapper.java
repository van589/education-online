package com.van589.mooc.web.admin.dao;

import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.domain.User;
import org.springframework.stereotype.Component;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

@Component
public interface UserMapper<T extends BaseRoleEntity> extends MyMapper<User> {
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
     * @return
     */
    int count();
}