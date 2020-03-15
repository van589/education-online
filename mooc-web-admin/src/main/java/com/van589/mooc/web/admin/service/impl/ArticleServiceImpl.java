package com.van589.mooc.web.admin.service.impl;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.commons.persistence.BaseService;
import com.van589.mooc.domain.Article;
import com.van589.mooc.domain.User;
import com.van589.mooc.web.admin.abstracts.AbstractBaseServiceImpl;
import com.van589.mooc.web.admin.dao.ArticleMapper;
import com.van589.mooc.web.admin.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl extends AbstractBaseServiceImpl<Article , ArticleMapper> implements ArticleService {

    /**
     * 新增或保存信息
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public BaseResult save(Article entity) {

        //设置基本属性
        entity.setAuthorId(entity.getAuthorId());
        entity.setArticleTitle(entity.getArticleTitle());
        entity.setArticleContent(entity.getArticleContent());

        //新增用户
        if (entity.getId() == null || entity.getId().isEmpty()) {
            Date first = new Date();
            entity.setId(UUID.randomUUID().toString().replace("-", ""));
            entity.setFirsttime(first);
            entity.setUpdatetime(first);
            dao.insert(entity);
        }

        // 编辑用户
        else {
            Article article = dao.selectById(entity.getId());
            entity.setFirsttime(article.getFirsttime());
            entity.setUpdatetime(new Date());
            dao.update(entity);
        }
        return BaseResult.success("保存用户信息成功");
    }
}
