package com.van589.mooc.web.api.Service.impl;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.domain.Article;
import com.van589.mooc.web.api.Service.ArticleService;
import com.van589.mooc.web.api.dao.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 分页查询操作
     *
     * @param params
     * @return
     */
    @Override
    public PageInfo<Article> page(Map<String, Object> params) {
        PageInfo<Article> pageInfo = new PageInfo<>();

        //获取前端传来的用户信息
        Article entity = (Article) params.get("pageParams");
        //查询用户总记录数
        int count = count(entity);
        //查询分页信息
        List<Article> entityList = articleMapper.page(params);

        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(entityList);

        return pageInfo;
    }

    /**
     * 查询用户总记录数
     *
     * @param entity
     * @return
     */
    @Override
    public int count(Article entity) {
        return articleMapper.count(entity);
    }

}
