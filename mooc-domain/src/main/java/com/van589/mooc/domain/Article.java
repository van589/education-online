package com.van589.mooc.domain;

import com.van589.mooc.commons.persistence.BaseTimeEntity;
import lombok.Data;

@Data
public class Article extends BaseTimeEntity {

    /**
     *文章id
     */
    private String id;

    /**
     * 文章作者id
     */
    private String authorId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章内容
     */
    private String articleContent;
}
