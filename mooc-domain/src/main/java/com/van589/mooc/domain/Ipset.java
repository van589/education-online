package com.van589.mooc.domain;

import com.van589.mooc.commons.persistence.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class Ipset extends BaseTimeEntity {
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

}