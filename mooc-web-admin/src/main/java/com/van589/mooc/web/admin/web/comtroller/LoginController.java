package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.commons.constant.ConstantUtils;
import com.van589.mooc.domain.Admin;
import com.van589.mooc.web.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {


    @Autowired
    private AdminService adminService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = {"","login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 登陆模块
     *
     * @param name
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String index(String name, String password, HttpServletRequest httpServletRequest, Model model) {
        Admin admin = adminService.login(name, password);

        // 登录失败
        if (admin == null) {
            model.addAttribute(ConstantUtils.SESSION_MESSAGE, "用户名或密码错误，请重新输入");
            return login();
        }

        // 登录成功
        else {
            // 将登录信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_Admin, admin);
            return "redirect:/main";
        }
    }

    /**
     * 注销
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();
        return login();
    }
}
