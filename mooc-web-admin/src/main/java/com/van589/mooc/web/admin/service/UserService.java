package com.van589.mooc.web.admin.service;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.commons.persistence.BaseService;
import com.van589.mooc.domain.User;

import javax.validation.Valid;
import java.util.Map;

public interface UserService extends BaseService<User> {

    /**
     * 批量删除
     * @param ids
     */
    public void deleteMulti(String[] ids);

    /**
     *充值一条或多条余额信息
     *
     * @param params
     */
    public void updateCollectMulti(Map<String,Object> params);

    /**
     * 充值一条或多条 VIP 时间信息
     *
     * @param params
     */
    public void updateVipSettingDateMulti(Map<String,Object> params);
}
