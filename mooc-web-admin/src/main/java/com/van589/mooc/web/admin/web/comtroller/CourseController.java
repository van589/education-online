package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.domain.Course;
import com.van589.mooc.web.admin.abstracts.AbstractBaseController;
import com.van589.mooc.web.admin.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "course")
public class CourseController extends AbstractBaseController<Course, CourseService> {

    /**
     * 跳转 课程列表 界面
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "course/course_list";
    }
}
