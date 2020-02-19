package com.van589.mooc.web.admin.dao;

import com.van589.mooc.domain.Admin;
import org.springframework.stereotype.Component;
import tk.mybatis.MyMapper;

@Component
public interface AdminMapper extends MyMapper<Admin> {
}