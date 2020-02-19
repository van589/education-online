package com.van589.mooc.commons.dto;


import com.van589.mooc.commons.persistence.BaseRoleEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据传输对象
 */
@Data
public class PageInfo<T extends BaseRoleEntity> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;

}
