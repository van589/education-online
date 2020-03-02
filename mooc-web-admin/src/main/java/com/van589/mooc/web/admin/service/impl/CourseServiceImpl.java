package com.van589.mooc.web.admin.service.impl;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.domain.Course;
import com.van589.mooc.web.admin.abstracts.AbstractBaseServiceImpl;
import com.van589.mooc.web.admin.dao.CourseMapper;
import com.van589.mooc.web.admin.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class CourseServiceImpl extends AbstractBaseServiceImpl<Course, CourseMapper> implements CourseService {

    /**
     * 新增或保存信息
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public BaseResult save(Course entity) {
        //新增用户
        if (entity.getId() == null || entity.getId().isEmpty()) {
            Date first = new Date();
            entity.setId(UUID.randomUUID().toString().replace("-", ""));
            entity.setName(entity.getName());
            entity.setIntroduction(entity.getIntroduction());
            entity.setType(entity.getType());
            entity.setPrice(entity.getPrice() == null ? 0 : entity.getPrice());
            entity.setLabel(entity.getLabel());
            entity.setFristtime(first);
            entity.setUpdatetime(first);
            dao.insert(entity);
        }
        return BaseResult.success("保存用户信息成功");
    }
}
