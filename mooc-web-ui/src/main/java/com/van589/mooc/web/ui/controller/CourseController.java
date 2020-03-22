package com.van589.mooc.web.ui.controller;

import com.van589.mooc.commons.constant.ConstantUtils;
import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.web.ui.api.CourseAPI;
import com.van589.mooc.web.ui.api.UserAPI;
import com.van589.mooc.web.ui.constant.SystemConstants;
import com.van589.mooc.web.ui.dto.Course;
import com.van589.mooc.web.ui.dto.CourseDetailDTO;
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
@RequestMapping(value = "course")
public class CourseController {

    //视频列表
    private List<Course> allCourse;

    /**
     * 加载课程视频
     *
     * @param model
     */
    @ModelAttribute
    public void loadBoutiqueCourse(Model model) throws Exception {
        allCourse = CourseAPI.getBoutiqueCourse();
        model.addAttribute("allCourse", allCourse);
    }

    /**
     * 跳转课程中心页面
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String course() {
        return "course/course_main";
    }

    /**
     * 跳转课程详细页
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(Model model,String id) throws Exception {
        CourseDetailDTO courseDetail = CourseAPI.getCourseDetail(id);
        model.addAttribute(ConstantUtils.SESSION_COURSE,courseDetail);
        return "course/course_detail";
    }
}
