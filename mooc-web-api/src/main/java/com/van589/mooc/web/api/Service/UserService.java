package com.van589.mooc.web.api.Service;

import com.van589.mooc.domain.User;

/**
 * 用户管理
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    public User login(User user);
}
