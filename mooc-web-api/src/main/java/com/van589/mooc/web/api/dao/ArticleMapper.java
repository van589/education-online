package com.van589.mooc.web.api.dao;

import com.van589.mooc.commons.persistence.BaseDao;
import com.van589.mooc.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArticleMapper {

    /**
     * 分页查询
     *
     * @param params，需要两个参数，start/记录开始的位置 length/每页记录数
     * @return
     */
    List<Article> page(Map<String, Object> params);

    /**
     * 查询总笔数
     *
     * @param entity
     * @return
     */
    int count(Article entity);
}
