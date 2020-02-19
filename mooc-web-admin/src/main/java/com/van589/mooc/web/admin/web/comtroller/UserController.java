package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.commons.constant.ConstantUtils;
import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.domain.Admin;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.service.AdminService;
import com.van589.mooc.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到用户列表页面
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "user_list";
    }

    /**
     *  DateTables 的分页查询
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<User> page(HttpServletRequest request){
        //获取 DateTables 的请求的参数
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");

        //设置请求参数
        Map<String,Object> params = new HashMap<>();
        params.put("page",Integer.parseInt(start));
        params.put("pageSize",Integer.parseInt(length));

        PageInfo<User> pageInfo = userService.page(params);

        pageInfo.setDraw(draw == null ? 0 : Integer.parseInt(draw));

        return pageInfo;
    }

    /**
     * 跳转用户表单页
      * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "user_form";
    }

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(User user, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = userService.save(user);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        }

        // 保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "user_form";
        }
    }
}
