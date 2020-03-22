package com.van589.mooc.web.ui.dto;

import com.van589.mooc.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
public class User extends BaseEntity {

    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户账户
     */
    private String name;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户手机号码
     */
    private String phone;

    /**
     * 邮箱地址
     */
    private String email;

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
