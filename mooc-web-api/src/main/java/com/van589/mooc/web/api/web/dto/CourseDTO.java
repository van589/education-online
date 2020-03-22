package com.van589.mooc.web.api.web.dto;

import com.van589.mooc.commons.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CourseDTO extends BaseEntity {

    /**
     * 课程ID
     */
    private String id;


    /**
     * 课程名称
     */
    private String name;


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
     * 课程封面
     */
    private String imageUrl;
}
