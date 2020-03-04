package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.commons.constant.ConstantUtils;
import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.domain.CourseFile;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.abstracts.AbstractBaseController;
import com.van589.mooc.web.admin.service.CourseFileService;
import com.van589.mooc.web.admin.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "file")
public class CourseFileController extends AbstractBaseController<CourseFile, CourseFileService> {

    /**
     * 跳转到 视频 列表页面
     *
     * @return
     */
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "course/file_list";
    }

    @Override
    public String form(Model model, String id) {
        return null;
    }

    @Override
    public String save(CourseFile entity, Model model, RedirectAttributes redirectAttributes) {
        return null;
    }

    @Override
    public String detail(Model model, String id) {
        return null;
    }

    @Override
    public BaseResult delete(String ids) {
        return null;
    }

    /**
     * 获取单个视频信息
     *
     * @param model
     * @param id
     */
    private void getUser(Model model, String id) {
        CourseFile entity = getEntity(id);
        model.addAttribute(ConstantUtils.SESSION_COURSEFILE, entity == null ? new CourseFile() : entity);
    }
}
