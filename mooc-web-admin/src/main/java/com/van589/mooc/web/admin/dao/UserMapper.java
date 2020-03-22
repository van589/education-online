package com.van589.mooc.web.admin.dao;

import com.van589.mooc.commons.persistence.BaseDao;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends BaseDao<User> {

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

    /**
     * 根据 ID 查找多条信息
     *
     * @param ids
     */
    public List<User> selectByMultiId(String[] ids);
}