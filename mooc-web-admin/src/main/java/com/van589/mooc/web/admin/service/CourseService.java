package com.van589.mooc.web.admin.service;

import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.commons.persistence.BaseService;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.CourseFile;

import java.util.List;

public interface CourseService extends BaseService<Course> {

    /**
     * 查询未绑定课程的视频
     *
     * @return
     */
    public List<CourseFile> selectCourseFileForBind();

    /**
     * 查询已绑定课程的视频
     *
     * @return
     */
    public List<CourseFile> selectCourseFileForUnbind();
}
