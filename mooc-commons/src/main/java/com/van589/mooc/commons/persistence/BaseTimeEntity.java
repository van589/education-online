package com.van589.mooc.commons.persistence;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseTimeEntity extends BaseEntity {

    /**
     * 创建时间
     */
    private Date firsttime;

    /**
     * 修改时间
     */
    private Date updatetime;
}
