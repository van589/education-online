package com.van589.mooc.web.ui.controller;

import com.van589.mooc.web.ui.api.CourseAPI;
import com.van589.mooc.web.ui.dto.Course;
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
        //如果精品视频为空则查询并返回
        if(boutiqueCourse == null){
            boutiqueCourse = CourseAPI.getBoutiqueCourse();
        }
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
}
