package com.van589.mooc.web.ui.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.van589.mooc.commons.utils.HttpClientUtils;
import com.van589.mooc.commons.utils.MapperUtils;
import com.van589.mooc.web.ui.dto.Course;
import com.van589.mooc.web.ui.dto.User;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程管理接口
 */
public class CourseAPI {

    /**
     * 获取精品课程数据
     *
     * @return
     */
    public static List<Course> getBoutiqueCourse() throws Exception{
        String json = HttpClientUtils.doGet(API.API_COURSES_BOUTIQUE);

        ObjectMapper mapper = new ObjectMapper();
        List<Course> readValue = mapper.readValue(json,new TypeReference<List<Course>>(){});
        return readValue;
    }

}
