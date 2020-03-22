package com.van589.mooc.web.ui.dto;

import com.van589.mooc.commons.persistence.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class Article extends BaseEntity {

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

    /**
     * 创建时间
     */
    private Date firsttime;

    /**
     * 修改时间
     */
    private Date updatetime;

}
