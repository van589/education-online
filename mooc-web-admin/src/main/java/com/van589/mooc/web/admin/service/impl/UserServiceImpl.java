package com.van589.mooc.web.admin.service.impl;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.abstracts.AbstractBaseServiceImpl;
import com.van589.mooc.web.admin.dao.UserMapper;
import com.van589.mooc.web.admin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends AbstractBaseServiceImpl<User, UserMapper> implements UserService {

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
            user.setFirsttime(first);
            user.setUpdatetime(first);
            user.setLasttime(first);
            dao.insert(user);
        }

        // 编辑用户
        else {
            User oldUser = (User) dao.selectById(user.getId());
            // 编辑用户时如果没有输入密码则沿用原来的密码
            if (StringUtils.isBlank(user.getPassword())) {
                user.setPassword(oldUser.getPassword());
            }
            // 验证密码是否符合规范，密码长度介于 6 - 20 位之间
            if (StringUtils.length(user.getPassword()) < 6 || StringUtils.length(user.getPassword()) > 20) {
                return BaseResult.fail("密码长度必须介于 6 - 20 位之间");
            }
            user.setVip(oldUser.getVip());
            user.setFirsttime(oldUser.getFirsttime());
            user.setUpdatetime(new Date());
            user.setLasttime(oldUser.getLasttime());
            dao.update(user);
        }
        return BaseResult.success("保存用户信息成功");
    }

    /**
     * 余额充值一条或多条信息
     *
     * @param params
     */
    @Override
    @Transactional(readOnly = false)
    public void updateCollectMulti(Map<String, Object> params) {
        dao.updateCollectMulti(params);
    }

    /**
     * 充值一条或多条 VIP 时间信息
     *
     * @param params
     */
    @Override
    @Transactional(readOnly = false)
    public void updateVipSettingDateMulti(Map<String, Object> params) {
        dao.updateVipSettingDateMulti(params);
    }

    /**
     * 根据 ID 查找多条信息
     *
     * @param ids
     */
    @Override
    public List<User> selectByMultiId(String[] ids) {
        return dao.selectByMultiId(ids);
    }

    /**
     * 根据键值批量插入
     *
     * @param mapList
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public BaseResult excelInputByList(List<Map<String, Object>> mapList) {
        List<User> userList = new ArrayList<>();
        for (Map<String, Object> map : mapList) {
            User user = new User();
            Date first = new Date();
            user.setId(UUID.randomUUID().toString().replace("-", ""));
            user.setName((String) map.get("账号"));
            user.setNickname((String) map.get("呢称"));
            user.setPassword((String) map.get("密码"));
            user.setSex((String) map.get("性别"));
            user.setPhone((String) map.get("手机"));
            user.setEmail((String) map.get("邮箱"));
            user.setWechar((String) map.get("微信"));
            user.setEducation((String) map.get("学历"));
            user.setFirsttime(first);
            user.setUpdatetime(first);
            user.setLasttime(first);
            userList.add(user);
        }
        dao.insertList(userList);
        return BaseResult.success("导入成功");
    }
}
