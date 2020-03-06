package com.van589.mooc.web.admin.dao;

import com.van589.mooc.commons.persistence.BaseDao;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.Ipset;
import org.springframework.stereotype.Component;
import tk.mybatis.MyMapper;

@Component
public interface CourseMapper extends BaseDao<Course> {
}
