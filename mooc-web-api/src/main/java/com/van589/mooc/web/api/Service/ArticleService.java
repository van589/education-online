package com.van589.mooc.web.api.Service;

import com.van589.mooc.commons.dto.PageInfo;
import com.van589.mooc.commons.persistence.BaseService;
import com.van589.mooc.domain.Article;

import java.util.Map;

public interface ArticleService {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    public PageInfo<Article> page(Map<String, Object> params);

    /**
     * 查询分页笔数
     *
     * @param entity
     * @return
     */
    public int count(Article entity);
}
