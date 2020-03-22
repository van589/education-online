package com.van589.mooc.web.admin.dao;

import com.van589.mooc.commons.persistence.BaseDao;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.Ipset;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

@Repository
public interface CourseMapper extends BaseDao<Course> {
}
