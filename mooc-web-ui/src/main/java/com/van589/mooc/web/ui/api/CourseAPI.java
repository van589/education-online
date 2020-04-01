package com.van589.mooc.web.ui.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.utils.HttpClientUtils;
import com.van589.mooc.commons.utils.MapperUtils;
import com.van589.mooc.web.ui.dto.Course;
import com.van589.mooc.web.ui.dto.CourseDetailDTO;
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
    public static List<Course> getBoutiqueCourse() throws Exception {
        String json = HttpClientUtils.doGet(API.API_COURSES_BOUTIQUE);

        ObjectMapper mapper = new ObjectMapper();
        List<Course> readValue = mapper.readValue(json, new TypeReference<List<Course>>() {});
        return readValue;
    }

    /**
     * 获取课程详细信息
     *
     * @param id
     * @return
     */
    public static CourseDetailDTO getCourseDetail(String id){
        String json = HttpClientUtils.doGet(API.API_COURSES_DETAIL + "?id=" + id);
        CourseDetailDTO courseDetailDTO = null;
        try {
            courseDetailDTO = MapperUtils.json2pojoByTree(json, "data", CourseDetailDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseDetailDTO;
    }

    /**
     * 获取搜索的课程
     *
     * @param name
     * @return
     * @throws Exception
     */
    public static List<Course> searchName(String name) throws Exception {
        String json = HttpClientUtils.doGet(API.API_COURSES_SEARCH + "?name=" + name);

        ObjectMapper mapper = new ObjectMapper();
        List<Course> readValue = mapper.readValue(json, new TypeReference<List<Course>>() {});
        return readValue;
    }

}
