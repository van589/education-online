package com.van589.mooc.web.admin.service;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.commons.persistence.BaseService;
import com.van589.mooc.domain.User;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface UserService extends BaseService<User> {



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

    /**
     * 根据 ID 查找多条信息
     *
     * @param ids
     */
    public List<User> selectByMultiId(String[] ids);

    /**
     * 根据键值批量插入
     *
     * @param mapList
     * @return
     */
    public BaseResult excelInputByList(List<Map<String,Object>> mapList);
}
