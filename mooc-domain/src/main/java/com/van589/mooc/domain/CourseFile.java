package com.van589.mooc.domain;

import com.van589.mooc.commons.persistence.BaseEntity;
import com.van589.mooc.commons.persistence.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CourseFile extends BaseTimeEntity {

    /**
     * 视频文件id
     */
    private String id;
    /**
     * 视频文件名
     */
    private String filename;
    /**
     * 视频文件路径
     */
    private String url;


}
