package com.van589.mooc.domain;

import com.van589.mooc.commons.persistence.BaseRoleEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
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