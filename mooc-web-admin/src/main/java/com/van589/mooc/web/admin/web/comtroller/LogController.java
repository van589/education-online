package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.domain.Log;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.abstracts.AbstractBaseController;
import com.van589.mooc.web.admin.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @Override
    @RequestMapping(value = "user_list", method = RequestMethod.GET)
    public String list() {
        return "log/log_user_list";
    }


    @Override
    public String form(Model model, String id) {
        return null;
    }

    @Override
    public String save(Log entity, Model model, RedirectAttributes redirectAttributes) {
        return null;
    }

    @Override
    public String detail(Model model, String id) {
        return null;
    }


}
