package com.van589.mooc.web.api.Service.impl;

import com.van589.mooc.domain.Course;
import com.van589.mooc.web.api.Service.CourseService;
import com.van589.mooc.web.api.dao.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService<Course> {

    @Autowired
    private CourseMapper courseMapper;

    /**
     *查询所有精品课程
     *
     * @return
     */
    @Override
    public List<Course> selectAllBoutique() {
        List<Course> courses = courseMapper.selectAll();
        if (courses.size() >= 6){
            //获取所有视频里的头六个
            courses.subList(0,6);
        }
        return courses;
    }
}
