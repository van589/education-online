package com.van589.mooc.web.admin.service;

import com.van589.mooc.commons.persistence.BaseService;
import com.van589.mooc.domain.CourseFile;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CourseFileService extends BaseService<CourseFile> {


    /**
     * 根据 ID 查询多条记录
     *
     * @param ids
     * @return
     */
    public List<CourseFile> selectMultiById(String[] ids);
}
