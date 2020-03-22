package com.van589.mooc.web.admin.service.impl;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.commons.persistence.BaseService;
import com.van589.mooc.domain.Admin;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.abstracts.AbstractBaseServiceImpl;
import com.van589.mooc.web.admin.dao.AdminMapper;
import com.van589.mooc.web.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class AdminServiecImpl extends AbstractBaseServiceImpl<Admin,AdminMapper> implements AdminService {

    /**
     * 管理员登录逻辑操作
     * @param name
     * @param password
     * @return
     */
    @Override
    public Admin login(String name, String password) {
        //创建查找条件
        Example example = new Example(Admin.class);
        Example.Criteria criteria = example.createCriteria();
        //以name为查找条件
        criteria.andEqualTo("name", name);
        List<Admin> admins = dao.selectByExample(example);
        //只要有值则匹配密码
        if (admins.size() > 0) {
            Admin admin = admins.get(0);
            //密码匹配成功则返回管理员数据
            if (password.equals(admin.getPassword())) {
                return admin;
            }
        }
        return null;
    }

    /**
     * 查询所有管理员
     *
     * @return
     */
    @Override
    public List<Admin> selectAll() {
        return dao.selectAll();
    }

    @Override
    public BaseResult save(Admin entity) {
        return null;
    }
}
