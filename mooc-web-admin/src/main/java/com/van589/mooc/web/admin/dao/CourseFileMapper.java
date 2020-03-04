package com.van589.mooc.web.admin.dao;

import com.van589.mooc.commons.persistence.BaseDao;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.CourseFile;
import org.springframework.stereotype.Component;
import tk.mybatis.MyMapper;

@Component
public interface CourseFileMapper extends BaseDao<CourseFile> {
}
