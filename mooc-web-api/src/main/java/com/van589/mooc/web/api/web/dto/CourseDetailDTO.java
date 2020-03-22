package com.van589.mooc.web.api.web.dto;

import com.van589.mooc.commons.persistence.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class CourseDetailDTO extends BaseEntity {

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程简介
     */
    private String introduction;

    /**
     * 课程评价
     */
    private String label;

    /**
     * 课程封面地址
     */
    private String imageUrl;

    /**
     * 课程创建日期
     */
    private Date firsttime;

    /**
     * 课程修改日期
     */
    private Date updatetime;

    /**
     * 课程视频的视频 URL
     */
    private String url;
}
