package com.van589.mooc.domain;

import com.van589.mooc.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
public class Course extends BaseEntity {

    /**
     * 课程ID
     */
    private String id;

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
     * 首次登录时间
     */
    private Date fristtime;

    /**
     * 修改时间
     */
    private Date updatetime;

}
