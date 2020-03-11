package com.van589.mooc.web.api.Service;

import com.van589.mooc.commons.persistence.BaseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CourseService<T extends BaseEntity> {

    /**
     * 查询所有精品课程
     *
     * @return
     */
    public List<T> selectAllBoutique();
}
