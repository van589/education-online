package com.van589.mooc.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Ipset {
    /**
     * 操作者ip
     */
    private String ip;

    /**
     * 是否封禁
     */
    private Boolean isban;

    /**
     * 操作类型
     */
    private String flag;

    /**
     * 封禁日期
     */
    private Date bantime;

    /**
     * 首次注册时间
     */
    private Date fristtime;

    /**
     * 最后登录时间
     */
    private Date lasttime;

}