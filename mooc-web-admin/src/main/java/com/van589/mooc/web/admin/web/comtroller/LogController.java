package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.domain.Log;
import com.van589.mooc.domain.User;
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
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 跳转到用户列表页面
     *
     * @return
     */
    @RequestMapping(value = "user_list", method = RequestMethod.GET)
    public String list() {
        return "log/log_user_list";
    }

    /**
     * DateTables 的分页查询
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<User> page(HttpServletRequest request, Log log) {
        //获取 DateTables 的请求的参数
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");

        //设置请求参数
        Map<String, Object> params = new HashMap<>();
        params.put("page", Integer.parseInt(start));
        params.put("pageSize", Integer.parseInt(length));
        params.put("pageParams", log);

        PageInfo<User> pageInfo = logService.page(params);

        pageInfo.setDraw(draw == null ? 0 : Integer.parseInt(draw));

        return pageInfo;
    }

}
