package com.van589.mooc.web.ui.controller;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.web.ui.api.UserAPI;
import com.van589.mooc.web.ui.constant.SystemConstants;
import com.van589.mooc.web.ui.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    /**
     * 跳转到门户登录界面
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 门户的用户登录请求
     *
     * @param user
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest request) throws Exception {
        user = UserAPI.login(user);
        // 登录失败
        if (user == null) {
            model.addAttribute("baseResult", BaseResult.fail("用户名或密码错误，请重新输入！"));
            return "login";
        }

        // 登录成功
        else {
            // 将会员信息放入 Session
            request.getSession().setAttribute(SystemConstants.SESSION_USER_KEY, user);
            return "redirect:/main";
        }
    }

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        if (request.getSession().getAttribute(SystemConstants.SESSION_USER_KEY) != null)
            request.getSession().invalidate();
        return "redirect:/main";
    }
}