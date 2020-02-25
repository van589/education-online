package com.van589.mooc.web.admin.service.impl;

import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.domain.Log;
import com.van589.mooc.web.admin.dao.LogMapper;
import com.van589.mooc.web.admin.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService<Log> {

    @Autowired
    private LogMapper logMapper;

    /**
     * 分页查询操作
     *
     * @param params
     * @return
     */
    @Override
    public PageInfo<Log> page(Map<String, Object> params) {
        PageInfo<Log> pageInfo = new PageInfo<>();

        //获取前端传来的用户信息
        Log log = (Log) params.get("pageParams");
        //查询用户总记录数
        int count = logMapper.count(log);
        //查询分页信息
        List<Log> logList = logMapper.page(params);

        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(logList);

        return pageInfo;
    }
}
