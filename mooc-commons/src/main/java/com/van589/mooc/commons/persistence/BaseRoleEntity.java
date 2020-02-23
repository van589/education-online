package com.van589.mooc.commons.persistence;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseRoleEntity implements Serializable {
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
    @Length(min = 6,max = 10,message = "用户昵称的长度必须介于 {min} - {max} 位之间")
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
     * 首次登录时间
     */
    private Date fristtime;

    /**
     * 修改时间
     */
    private Date updatetime;

    /**
     * 最后登录时间
     */
    private Date lasttime;

}
