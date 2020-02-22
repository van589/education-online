package com.van589.mooc.web.admin.service.impl;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.dao.UserMapper;
import com.van589.mooc.web.admin.service.UserService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService<User> {

    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询操作
     *
     * @param params
     * @return
     */
    @Override
    public PageInfo<User> page(Map<String, Object> params) {
        PageInfo<User> pageInfo = new PageInfo<>();

        //获取前端传来的用户信息
        User user = (User) params.get("pageParams");
        //查询用户总记录数
        int count = userMapper.count(user);
        //查询分页信息
        List<User> users = userMapper.page(params);

        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(users);

        return pageInfo;
    }

    /**
     * 查询用户总记录数
     * @param user
     * @return
     */
    @Override
    public int count(User user) {
        return userMapper.count(user);
    }

    /**
     * 新增或保存信息
     *
     * @param user
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public BaseResult save(User user) {
        //此处应该有检验，现暂时略过
        /*String validator = BeanValidator.validator(user);
        if (validator != null) {
            return BaseResult.fail(validator);
        }*/
        Date first = new Date();
        user.setUpdatetime(first);

        //新增用户
        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString().replace("-", ""));
            user.setWechar(user.getWechar().isEmpty() ? "无" : user.getWechar());
            user.setCollect(user.getCollect() == null ? 0 : user.getCollect());
            user.setEducation(user.getEducation().isEmpty() ? "无" : user.getEducation());
            user.setPassword(user.getPassword());
            user.setFristtime(first);
            user.setLasttime(first);
            userMapper.insert(user);
        }

        // 编辑用户
        else {

        }


        return BaseResult.success("保存用户信息成功");
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteMulti(String[] ids) {
        userMapper.deleteMulti(ids);
    }
}
