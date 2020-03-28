package com.van589.mooc.web.api.web.controller.v1;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.api.Service.UserService;
import com.van589.mooc.web.api.web.dto.UserDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseResult login(User user) {
        user = userService.login(user);
        //未查找到用户则返回错误信息
        if (user == null) {
            return BaseResult.fail("账号或密码错误");
        }
        //查早到则返回用户的DTO
        else {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            return BaseResult.success("登录成功", userDTO);
        }
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public BaseResult register(User user) {
        BaseResult baseResult = BaseResult.fail("插入失败");
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        int result = userService.register(user);
        if (result != 0) {
            baseResult = BaseResult.success("插入成功");
        }
        return baseResult;
    }

    /**
     * 检查用户名是否存在
     *
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "checkName",method = RequestMethod.GET)
    public BaseResult checkUserName(String name){
        BaseResult baseResult = BaseResult.fail("用户名已存在");
        User user = userService.checkUserName(name);
        if (user == null && !StringUtils.isEmpty(name)) {
            baseResult = BaseResult.success("用户名可用");
        }
        return baseResult;
    }
}
