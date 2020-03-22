package com.van589.mooc.web.api.dao;

import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.CourseFile;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface CourseFileMapper<T extends BaseEntity> {

    /**
     * 根据 ID 查询视频
     *
     * @param id
     * @return
     */
    public T selectById(String id);
}
