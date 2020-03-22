package com.van589.mooc.web.api.Service;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.web.api.web.dto.CourseDetailDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CourseService<T extends BaseEntity> {

    /**
     * 查询所有精品课程
     *
     * @return
     */
    public List<T> selectAllBoutique();

    /**
     * 查询单个课程信息
     * @return
     */
    public CourseDetailDTO selectCourseById(String id);
}
