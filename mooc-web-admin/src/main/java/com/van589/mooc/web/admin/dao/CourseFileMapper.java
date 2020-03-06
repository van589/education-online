package com.van589.mooc.web.admin.dao;

import com.van589.mooc.commons.persistence.BaseDao;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.CourseFile;
import org.springframework.stereotype.Component;
import tk.mybatis.MyMapper;

import java.util.List;

@Component
public interface CourseFileMapper extends BaseDao<CourseFile> {

    /**
     * 根据 ID 查询多条记录
     *
     * @param ids
     * @return
     */
    public List<CourseFile> selectMultiById(String[] ids);

    /**
     * 查询未关联到课程的视频
     *selectUnbindCourseFileById
     * @return
     */
    public List<CourseFile> selectUnbindCourseFileById();

    /**
     * 查询已关联到课程的视频
     *
     * @return
     */
    public List<CourseFile> selectBindCourseFileById();
}
