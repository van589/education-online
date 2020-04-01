package com.van589.mooc.web.api.web.controller.v1;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.domain.Article;
import com.van589.mooc.web.api.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    /**
     * DateTables 的分页查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<Article> page(HttpServletRequest request, Article entity) {
        //获取 DateTables 的请求的参数
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String pageParams = request.getParameter("pageParams");

        entity.setArticleTitle(pageParams);

        //设置请求参数
        Map<String, Object> params = new HashMap<>();
        params.put("page", Integer.parseInt(start));
        params.put("pageSize", Integer.parseInt(length));
        params.put("pageParams", entity);

        PageInfo<Article> pageInfo = articleService.page(params);

        pageInfo.setDraw(draw == null ? 0 : Integer.parseInt(draw));

        return pageInfo;
    }

    /**
     * 根据 ID 查询文章信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public BaseResult detail(String id){
        BaseResult baseResult = BaseResult.fail("查询错误");
        Article article = articleService.selectById(id);
        //如果查询成功则返回文章信息
        if(article != null){
            baseResult = BaseResult.success("查询成功",article);
        }

        return baseResult;
    }
}
