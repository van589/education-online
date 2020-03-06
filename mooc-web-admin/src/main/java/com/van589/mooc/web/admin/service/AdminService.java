package com.van589.mooc.web.admin.service;

import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.commons.persistence.BaseService;
import com.van589.mooc.domain.Admin;
import com.van589.mooc.domain.User;

import java.util.List;
import java.util.Map;

public interface AdminService extends BaseService<Admin> {

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    public Admin login(String username, String password);


}
