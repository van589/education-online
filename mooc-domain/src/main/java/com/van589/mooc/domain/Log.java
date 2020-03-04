package com.van589.mooc.domain;

import com.van589.mooc.commons.persistence.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class Log extends BaseEntity {
    /**
     * 日志id
     */
    private Long id;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 操作动作
     */
    private String type;

    /**
     * 操作时间
     */
    private Date operationtime;
}