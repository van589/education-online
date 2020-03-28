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

    /**
     * 插入信息
     *
     * @param user
     * @return
     */
    public int insert(User user);

    /**
     * 根据用户名查询
     *
     * @param name
     * @return
     */
    public User selectByName(String name);
}
