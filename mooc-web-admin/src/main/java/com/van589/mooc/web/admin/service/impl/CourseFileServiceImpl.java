package com.van589.mooc.web.admin.service.impl;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.CourseFile;
import com.van589.mooc.web.admin.abstracts.AbstractBaseServiceImpl;
import com.van589.mooc.web.admin.dao.CourseFileMapper;
import com.van589.mooc.web.admin.dao.CourseMapper;
import com.van589.mooc.web.admin.service.CourseFileService;
import com.van589.mooc.web.admin.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CourseFileServiceImpl extends AbstractBaseServiceImpl<CourseFile, CourseFileMapper> implements CourseFileService {

    @Override
    public BaseResult save(CourseFile entity) {
        return null;
    }
}
