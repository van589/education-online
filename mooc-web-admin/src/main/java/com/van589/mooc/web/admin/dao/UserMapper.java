package com.van589.mooc.web.admin.dao;

import com.van589.mooc.commons.persistence.BaseDao;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.domain.User;
import org.springframework.stereotype.Component;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

@Component
public interface UserMapper extends MyMapper<User>, BaseDao<User> {

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 更新单条用户信息
     *
     * @param entity
     */
    void update(User entity);

    /**
     * 批量更新用户余额
     *
     * @param params
     */
    public void updateCollectMulti(Map<String, Object> params);

    /**
     * 批量更新用户 VIP 时间
     *
     * @param params
     */
    public void updateVipSettingDateMulti(Map<String,Object> params);
}