package com.van589.mooc.web.api.web.controller.v1;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.api.Service.UserService;
import com.van589.mooc.web.api.web.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(User user){
        user = userService.login(user);
        //未查找到用户则返回错误信息
        if (user == null){
            return BaseResult.fail("账号或密码错误");
        }
        //查早到则返回用户的DTO
        else{
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user,userDTO);
            return BaseResult.success("登录成功",userDTO);
        }
    }
}
