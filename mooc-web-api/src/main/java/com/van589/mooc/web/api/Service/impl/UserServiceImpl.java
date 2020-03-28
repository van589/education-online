package com.van589.mooc.web.api.Service.impl;

import com.van589.mooc.domain.User;
import com.van589.mooc.web.api.Service.UserService;
import com.van589.mooc.web.api.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        User login = userMapper.login(user);

        //如果返回用户的信息不为空，且密码与输入的密码匹配则返回用户信息
        if(login != null && user.getPassword().equals(login.getPassword())){
            return login;
        }

        return null;
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    public int register(User user) {
        return userMapper.insert(user);
    }

    /**
     * 检查用户名是否存在
     *
     * @param name
     * @return
     */
    @Override
    public User checkUserName(String name) {
        return userMapper.selectByName(name);
    }
}
