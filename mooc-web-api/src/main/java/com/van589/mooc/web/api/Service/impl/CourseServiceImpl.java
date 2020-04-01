package com.van589.mooc.web.api.Service.impl;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.commons.utils.BeanCopyUtil;
import com.van589.mooc.domain.Admin;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.CourseFile;
import com.van589.mooc.web.api.Service.CourseService;
import com.van589.mooc.web.api.dao.CourseFileMapper;
import com.van589.mooc.web.api.dao.CourseMapper;
import com.van589.mooc.web.api.web.dto.CourseDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService<Course> {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseFileMapper courseFileMapper;

    /**
     * 查询所有精品课程
     *
     * @return
     */
    @Override
    public List<Course> selectAllBoutique() {
        List<Course> courses = courseMapper.selectAll();
        if (courses.size() >= 6) {
            //获取所有视频里的头六个
            courses.subList(0, 6);
        }
        return courses;
    }

    /**
     * 查询单个课程信息
     *
     * @return
     */
    @Override
    public CourseDetailDTO selectCourseById(String id) {
        //查找课程和对于的视频信息
        Course course = (Course) courseMapper.selectById(id);
        CourseFile courseFile = (CourseFile) courseFileMapper.selectById(course.getFileId());
        //将返回的结果拷贝的DTO中
        CourseDetailDTO courseDetailDTO = new CourseDetailDTO();
        BeanCopyUtil.copyProperties(courseFile,courseDetailDTO);
        BeanCopyUtil.copyProperties(course,courseDetailDTO);
        return courseDetailDTO;
    }

    /**
     * 根据字段查询所有课程信息
     *
     * @param name
     * @return
     */
    @Override
    public List<Course> selectAllCourseByName(String name) {
        return courseMapper.selectAll(name);
    }
}
