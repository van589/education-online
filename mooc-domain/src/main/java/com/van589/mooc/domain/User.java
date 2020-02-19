package com.van589.mooc.domain;

import com.van589.mooc.commons.persistence.BaseRoleEntity;
import lombok.Data;

import java.util.Date;

@Data
public class User extends BaseRoleEntity {
    /**
     * 微信号
     */
    private String wechar;

    /**
     * 用户余额
     */
    private Integer collect;

    /**
     * 教育程度
     */
    private String education;

    /**
     * vip日期
     */
    private Date vip;

}