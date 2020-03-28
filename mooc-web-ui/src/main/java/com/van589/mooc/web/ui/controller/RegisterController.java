package com.van589.mooc.web.ui.controller;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.web.ui.api.UserAPI;
import com.van589.mooc.web.ui.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "register")
public class RegisterController {

    /**
     * 跳转注册页面
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    /**
     * 对用户进行注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String register(User user) throws Exception {
        BaseResult result = UserAPI.register(user);
        if (result.getStatus() == 200) {
            return "redirect:/login";
        }
        return "register";
    }

    /**
     * 检查用户名是否重复
     *
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public BaseResult checkName(String name) throws Exception {
        BaseResult baseResult = UserAPI.checkName(name);
        return baseResult;
    }
}
