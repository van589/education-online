package com.van589.mooc.web.admin.web.comtroller;

import com.van589.mooc.commons.constant.ConstantUtils;
import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.domain.Admin;
import com.van589.mooc.domain.Article;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.abstracts.AbstractBaseController;
import com.van589.mooc.web.admin.service.AdminService;
import com.van589.mooc.web.admin.service.ArticleService;
import io.micrometer.core.instrument.util.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "article")
public class ArticleController extends AbstractBaseController<Article, ArticleService> {

    @Autowired
    private AdminService adminService;

    @ModelAttribute
    public void getAdminList(Model model){
        model.addAttribute("adminList", adminService.selectAll());
    }

    /**
     * 跳转到文章列表页面
     *
     * @return
     */
    @Override
    public String list() {
        return "article/article_list";
    }

    /**
     * 跳转到文章列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        return list();
    }

    /**
     * 跳转用户表单页
     *
     * @return
     */
    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model, String id) {
        getArticle(model, id);
        return "article/article_form";
    }

    /**
     * 保存用户信息
     *
     * @param entity
     * @param model
     * @param redirectAttributes
     * @return
     */
    @Override
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Article entity, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(entity);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "redirect:/article/list";
        }

        // 保存失败
        else {
            model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "article/article_form";
        }
    }

    @Override
    public String detail(Model model, String id) {
        return null;
    }

    /**
     * 删除一条或多条文章信息
     *
     * @param ids
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("删除文章成功");
        } else {
            baseResult = BaseResult.fail("删除文章失败");
        }

        return baseResult;
    }

    /**
     * 获取单个用户信息
     *
     * @param model
     * @param id
     */
    private void getArticle(Model model, String id) {
        Article article = getEntity(id);
        model.addAttribute(ConstantUtils.SESSION_ARTICLE, article == null ? new Article() : article);
        //如果为编辑文章则返回文章作者呢称
        if (id != null){
            Admin admin = adminService.getById(article.getAuthorId());
            model.addAttribute("adminNickName",admin.getNickname());
        }
    }
}
