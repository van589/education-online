package com.van589.mooc.web.api.dao;

import com.van589.mooc.domain.Course;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Repository
public interface CourseMapper{

    /**
     * 查询所有课程信息
     *
     * @return
     */
    public List<Course> selectAll();

}
