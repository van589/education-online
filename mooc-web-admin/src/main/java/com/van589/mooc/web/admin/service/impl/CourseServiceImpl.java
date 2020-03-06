package com.van589.mooc.web.admin.service.impl;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.CourseFile;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.abstracts.AbstractBaseServiceImpl;
import com.van589.mooc.web.admin.dao.CourseFileMapper;
import com.van589.mooc.web.admin.dao.CourseMapper;
import com.van589.mooc.web.admin.service.CourseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class CourseServiceImpl extends AbstractBaseServiceImpl<Course, CourseMapper> implements CourseService {

    @Autowired
    private CourseFileMapper courseFileMapper;

    /**
     * 新增或保存信息
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public BaseResult save(Course entity) {
        //无论新增还是修改，以下字段都需要设置
        entity.setName(entity.getName());
        entity.setIntroduction(entity.getIntroduction());
        entity.setType(entity.getType());
        entity.setPrice(entity.getPrice() == null ? 0 : entity.getPrice());
        entity.setLabel(entity.getLabel());
        entity.setFileId(entity.getFileId());

        //新增课程信息
        if (entity.getId() == null || entity.getId().isEmpty()) {
            Date first = new Date();
            //设置UUID
            entity.setId(UUID.randomUUID().toString().replace("-", ""));
            entity.setFirsttime(first);
            entity.setUpdatetime(first);
            dao.insert(entity);
        }
        // 编辑课程信息
        else {
            entity.setUpdatetime(new Date());
            dao.update(entity);
        }
        return BaseResult.success("保存用户信息成功");
    }

    /**
     * 查询未绑定课程的视频
     *
     * @return
     */
    @Override
    public List<CourseFile> selectCourseFileForBind() {
        return courseFileMapper.selectUnbindCourseFileById();
    }

    /**
     * 查询已绑定课程的视频
     *
     * @return
     */
    @Override
    public List<CourseFile> selectCourseFileForUnbind() {
        return courseFileMapper.selectBindCourseFileById();
    }
}
