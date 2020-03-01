package com.van589.mooc.web.admin.dao;

import com.van589.mooc.commons.persistence.BaseDao;
import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.commons.persistence.BaseRoleEntity;
import com.van589.mooc.domain.Log;
import org.springframework.stereotype.Component;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

@Component
public interface LogMapper extends MyMapper<Log> , BaseDao<Log> {

}