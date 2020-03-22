package com.van589.mooc.web.admin.dao;

import com.van589.mooc.commons.persistence.BaseDao;
import com.van589.mooc.domain.Ipset;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

@Repository
public interface IpsetMapper extends BaseDao<Ipset> {
}