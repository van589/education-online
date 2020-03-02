package com.van589.mooc.web.admin.abstracts;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseDao;
import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.commons.persistence.BaseService;
import com.van589.mooc.domain.Course;
import com.van589.mooc.domain.Log;
import com.van589.mooc.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 所有 ServiceImpl 的基类
 *
 * @param <T>
 * @param <D>
 */
public abstract class AbstractBaseServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements BaseService<T> {

    @Autowired
    protected D dao;

    /**
     * 分页查询操作
     *
     * @param params
     * @return
     */
    @Override
    public PageInfo<T> page(Map<String, Object> params) {
        PageInfo<T> pageInfo = new PageInfo<>();

        //获取前端传来的用户信息
        T entity = (T) params.get("pageParams");
        //查询用户总记录数
        int count = count(entity);
        //查询分页信息
        List<T> entityList = dao.page(params);

        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(entityList);

        return pageInfo;
    }

    /**
     * 查询用户总记录数
     *
     * @param entity
     * @return
     */
    @Override
    public int count(T entity) {
        return dao.count(entity);
    }

    /**
     * 查询单条信息
     *
     * @param id
     * @return
     */
    @Override
    public T getById(String id) {
        return dao.selectById(id);
    }
}
