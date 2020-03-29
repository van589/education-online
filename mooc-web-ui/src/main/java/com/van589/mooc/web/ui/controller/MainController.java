package com.van589.mooc.web.ui.controller;

import com.van589.mooc.commons.constant.ConstantUtils;
import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.web.ui.api.CourseAPI;
import com.van589.mooc.web.ui.api.UserAPI;
import com.van589.mooc.web.ui.dto.Course;
import com.van589.mooc.web.ui.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    //精品视频列表
    private List<Course> boutiqueCourse;

    /**
     * 加载精品视频
     *
     * @param model
     */
    @ModelAttribute
    public void loadBoutiqueCourse(Model model) throws Exception {
        boutiqueCourse = CourseAPI.getBoutiqueCourse().subList(0, 6);
        model.addAttribute("boutiqueCourse", boutiqueCourse);
    }

    /**
     * 跳转首页界面
     *
     * @return
     */
    @RequestMapping(value = {"", "main"}, method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    /**
     * 跳转用户细节
     *
     * @return
     */
    @RequestMapping(value = "/users/edit", method = RequestMethod.GET)
    public String detail() {
        return "users_edit";
    }

    /**
     * 跳转用户细节
     *
     * @return
     */
    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String detail(Model model, User user) throws Exception {
        BaseResult baseResult = UserAPI.edit(user);
        model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
        return "users_edit";
    }
}
