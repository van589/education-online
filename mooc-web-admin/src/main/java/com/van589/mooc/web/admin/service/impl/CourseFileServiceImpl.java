package com.van589.mooc.web.admin.service.impl;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.CourseFile;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.abstracts.AbstractBaseServiceImpl;
import com.van589.mooc.web.admin.dao.CourseFileMapper;
import com.van589.mooc.web.admin.dao.CourseMapper;
import com.van589.mooc.web.admin.service.CourseFileService;
import com.van589.mooc.web.admin.service.CourseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class CourseFileServiceImpl extends AbstractBaseServiceImpl<CourseFile, CourseFileMapper> implements CourseFileService {

    /**
     * 新增或保存信息
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public BaseResult save(CourseFile entity) {

        //无论新增还是修改，以下字段都需要设置
        entity.setFilename(entity.getFilename());
        entity.setUrl(entity.getUrl());

        //新增用户
        if (entity.getId() == null || entity.getId().isEmpty()) {
            Date first = new Date();
            entity.setId(UUID.randomUUID().toString().replace("-", ""));
            entity.setFirsttime(first);
            entity.setUpdatetime(first);
            dao.insert(entity);
        }

        // 编辑用户
        else {
            entity.setUpdatetime(new Date());
            dao.update(entity);
        }
        return BaseResult.success("保存用户信息成功");
    }

    /**
     * 根据 ID 查询多条记录
     *
     * @param ids
     * @return
     */
    @Override
    public List<CourseFile> selectMultiById(String[] ids) {
        return dao.selectMultiById(ids);
    }
}
