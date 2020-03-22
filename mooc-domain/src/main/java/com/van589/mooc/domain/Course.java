package com.van589.mooc.domain;

import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.commons.persistence.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class Course extends BaseTimeEntity {

    /**
     * 课程ID
     */
    private String id;

    /**
     * 视频表id
     */
    private String fileId;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程简介
     */
    private String introduction;

    /**
     * 课程类型
     */
    private String type;

    /**
     * 课程价格
     */
    private Integer price;

    /**
     * 课程评价
     */
    private String label;

    /**
     * 课程封面地址
     */
    private String imageUrl;

}
