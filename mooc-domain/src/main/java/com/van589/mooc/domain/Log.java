package com.van589.mooc.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Log {
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