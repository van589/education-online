package com.van589.mooc.web.admin.dao;

import com.van589.mooc.commons.persistence.BaseDao;
import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.domain.Log;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

@Repository
public interface LogMapper extends BaseDao<Log> {

}