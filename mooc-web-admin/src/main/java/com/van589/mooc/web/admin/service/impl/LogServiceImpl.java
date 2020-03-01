package com.van589.mooc.web.admin.service.impl;

import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.domain.Log;
import com.van589.mooc.web.admin.abstracts.AbstractBaseServiceImpl;
import com.van589.mooc.web.admin.dao.LogMapper;
import com.van589.mooc.web.admin.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl extends AbstractBaseServiceImpl<Log, LogMapper> implements LogService {

}
