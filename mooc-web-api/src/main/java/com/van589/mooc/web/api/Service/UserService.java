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

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    public int register(User user);

    /**
     * 检查用户名是否存在
     *
     * @param name
     * @return
     */
    public User checkUserName(String name);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    public int update(User user);
}
