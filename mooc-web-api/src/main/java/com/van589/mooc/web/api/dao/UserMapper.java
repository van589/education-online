package com.van589.mooc.web.api.dao;

import com.van589.mooc.domain.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    public User login (User user);
}
