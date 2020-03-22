package com.van589.mooc.web.api.dao;

import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.domain.Course;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Repository
public interface CourseMapper<T extends BaseEntity>{

    /**
     * 查询所有课程信息
     *
     * @return
     */
    public List<T> selectAll();

    /**
     * 根据 ID 查询课程
     *
     * @param id
     * @return
     */
    public T selectById(String id);

}
