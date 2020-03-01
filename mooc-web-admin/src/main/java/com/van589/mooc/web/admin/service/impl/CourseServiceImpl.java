package com.van589.mooc.web.admin.service.impl;

import com.van589.mooc.domain.Course;
import com.van589.mooc.web.admin.abstracts.AbstractBaseServiceImpl;
import com.van589.mooc.web.admin.dao.CourseMapper;
import com.van589.mooc.web.admin.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends AbstractBaseServiceImpl<Course, CourseMapper> implements CourseService {

}
