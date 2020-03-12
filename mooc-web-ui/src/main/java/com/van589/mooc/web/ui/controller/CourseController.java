package com.van589.mooc.web.ui.controller;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.web.ui.api.CourseAPI;
import com.van589.mooc.web.ui.api.UserAPI;
import com.van589.mooc.web.ui.constant.SystemConstants;
import com.van589.mooc.web.ui.dto.Course;
import com.van589.mooc.web.ui.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CourseController {

    //视频列表
    private List<Course> allCourse;

    /**
     * 加载精品视频
     *
     * @param model
     */
    @ModelAttribute
    public void loadBoutiqueCourse(Model model) throws Exception {
        //如果精品视频为空则查询并返回
        if(allCourse == null){
            allCourse = CourseAPI.getBoutiqueCourse();
        }
        model.addAttribute("allCourse", allCourse);
    }

    /**
     * 跳转视频中心页面
     *
     * @return
     */
    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String course() {
        return "course/course_main";
    }
}
