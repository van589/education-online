package com.van589.mooc.web.admin.service.impl;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.dao.UserMapper;
import com.van589.mooc.web.admin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     *
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
        //新增用户
        if (user.getId() == null || user.getId().isEmpty()) {
            Date first = new Date();
            user.setId(UUID.randomUUID().toString().replace("-", ""));
            user.setWechar(user.getWechar().isEmpty() ? "无" : user.getWechar());
            user.setCollect(user.getCollect() == null ? 0 : user.getCollect());
            user.setEducation(user.getEducation().isEmpty() ? "无" : user.getEducation());
            user.setPassword(user.getPassword());
            user.setFristtime(first);
            user.setUpdatetime(first);
            user.setLasttime(first);
            userMapper.insert(user);
        }

        // 编辑用户
        else {
            User oldUser = (User) userMapper.selectById(user.getId());
            // 编辑用户时如果没有输入密码则沿用原来的密码
            if (StringUtils.isBlank(user.getPassword())) {
                user.setPassword(oldUser.getPassword());
            }
            // 验证密码是否符合规范，密码长度介于 6 - 20 位之间
            if (StringUtils.length(user.getPassword()) < 6 || StringUtils.length(user.getPassword()) > 20) {
                return BaseResult.fail("密码长度必须介于 6 - 20 位之间");
            }
            user.setVip(oldUser.getVip());
            user.setFristtime(oldUser.getFristtime());
            user.setUpdatetime(new Date());
            user.setLasttime(oldUser.getLasttime());
            update(user);
        }
        return BaseResult.success("保存用户信息成功");
    }


    /**
     * 更新单条用户信息
     *
     * @param user
     */
    public void update(User user) {
        userMapper.update(user);
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

    /**
     * 查询单条信息
     *
     * @param id
     * @return
     */
    @Override
    public User getById(String id) {
        return (User) userMapper.selectById(id);
    }

    /**
     * 余额充值一条或多条信息
     *
     * @param params
     */
    @Override
    @Transactional(readOnly = false)
    public void updateCollectMulti(Map<String,Object> params) {
        userMapper.updateCollectMulti(params);
    }

    /**
     * 充值一条或多条 VIP 时间信息
     *
     * @param params
     */
    @Override
    @Transactional(readOnly = false)
    public void updateVipSettingDateMulti(Map<String, Object> params) {
        userMapper.updateVipSettingDateMulti(params);
    }
}
