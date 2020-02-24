package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.commons.constant.ConstantUtils;
import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.domain.Admin;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.service.AdminService;
import com.van589.mooc.web.admin.service.UserService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;
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
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "user_list";
    }

    /**
     * DateTables 的分页查询
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<User> page(HttpServletRequest request, User user) {
        //获取 DateTables 的请求的参数
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");

        //设置请求参数
        Map<String, Object> params = new HashMap<>();
        params.put("page", Integer.parseInt(start));
        params.put("pageSize", Integer.parseInt(length));
        params.put("pageParams", user);

        PageInfo<User> pageInfo = userService.page(params);

        pageInfo.setDraw(draw == null ? 0 : Integer.parseInt(draw));

        return pageInfo;
    }

    /**
     * 跳转用户表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model, String id) {
        getUser(model, id);
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
            redirectAttributes.addFlashAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "redirect:/user/list";
        }

        // 保存失败
        else {
            model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "user_form";
        }
    }

    /**
     * 删除用户信息
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            userService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }

        return baseResult;
    }

    /**
     * 显示用户详情
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, String id) {
        getUser(model, id);
        return "includes/user_detail";
    }

    /**
     * 跳转充值界面
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "recharge" ,method = RequestMethod.POST)
    public BaseResult recharge(String ids,Integer rechargeInput){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            Map params = new HashMap();
            params.put("collect",rechargeInput);
            params.put("ids",idArray);
            userService.updateCollectMulti(params);
            baseResult = BaseResult.success("充值成功");
        } else {
            baseResult = BaseResult.fail("充值失败");
        }

        return baseResult;
    }

    /**
     * 跳转充值界面
     * @return
     */
    @RequestMapping(value = "recharge" ,method = RequestMethod.GET)
    public String recharge(){
        return "includes/recharge_default";
    }

    /**
     * 获取单个用户信息
     *
     * @param model
     * @param id
     */
    private void getUser(Model model, String id) {
        User user = null;

        //如果 id 不为空则将用户信息查询出来，否则返回一个空的用户信息
        if (id != null) {
            user = (User) userService.getById(id);
        } else {
            user = new User();
        }
        model.addAttribute(ConstantUtils.SESSION_USER, user);
    }
}
