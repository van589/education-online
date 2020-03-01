package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.domain.Log;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.abstracts.AbstractBaseController;
import com.van589.mooc.web.admin.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "log")
public class LogController extends AbstractBaseController<Log, LogService> {


    /**
     * 跳转到用户列表页面
     *
     * @return
     */
    @RequestMapping(value = "user_list", method = RequestMethod.GET)
    public String list() {
        return "log/log_user_list";
    }
}
