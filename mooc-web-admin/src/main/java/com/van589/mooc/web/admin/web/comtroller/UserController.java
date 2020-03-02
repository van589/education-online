package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.commons.constant.ConstantUtils;
import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.abstracts.AbstractBaseController;
import com.van589.mooc.web.admin.service.UserService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "user")
public class UserController extends AbstractBaseController<User, UserService> {

    /**
     * 跳转到用户列表页面
     *
     * @return
     */
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "user/user_list";
    }

    /**
     * 跳转用户表单页
     *
     * @return
     */
    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model, String id) {
        getUser(model,id);
        return "user/user_form";
    }

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @Override
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(User user, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(user);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "redirect:/user/list";
        }

        // 保存失败
        else {
            model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "user/user_form";
        }
    }

    /**
     * 删除一条或多条课程信息
     *
     * @param ids
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }

        return baseResult;
    }

    /**
     * 显示用户详情
     *
     * @param model
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, String id) {
        getUser(model, id);
        return "includes/user/user_detail";
    }

    /**
     * 余额充值处理
     *
     * @param ids
     * @param rechargeInput
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "recharge", method = RequestMethod.POST)
    public BaseResult recharge(String ids, Integer rechargeInput) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            Map params = new HashMap();
            params.put("collect", rechargeInput);
            params.put("ids", idArray);
            service.updateCollectMulti(params);
            baseResult = BaseResult.success("充值成功");
        } else {
            baseResult = BaseResult.fail("充值失败");
        }

        return baseResult;
    }

    /**
     * 跳转模态框的余额充值界面
     *
     * @return
     */
    @RequestMapping(value = "recharge", method = RequestMethod.GET)
    public String recharge() {
        return "includes/user/recharge_default";
    }

    /**
     * VIP 设置处理
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "vipSetting", method = RequestMethod.POST)
    public BaseResult vipSettring(String ids, Integer vipDate) {
        BaseResult baseResult = BaseResult.fail("VIP设置失败");
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            Map params = new HashMap();
            params.put("vipDate", vipDate);
            params.put("ids", idArray);
            service.updateVipSettingDateMulti(params);
            baseResult = BaseResult.success("VIP设置成功");
        }

        return baseResult;
    }

    /**
     * 跳转模态框的 VIP 设置界面
     *
     * @return
     */
    @RequestMapping(value = "vipSetting", method = RequestMethod.GET)
    public String vipSetting() {
        return "includes/user/vip_setting_default";
    }

    /**
     * 获取单个用户信息
     *
     * @param model
     * @param id
     */
    private void getUser(Model model, String id) {
        User user = getEntity(id);
        model.addAttribute(ConstantUtils.SESSION_USER, user == null ? new User() : user);
    }
}
