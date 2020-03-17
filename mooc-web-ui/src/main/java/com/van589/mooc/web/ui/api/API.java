package com.van589.mooc.web.ui.api;

/**
 * API类
 */
public class API {

    // 主机地址
    public static final String HOST = "http://localhost:8091/api/v1";

    // 会员管理接口 - 登录
    public static final String API_USERS_LOGIN = HOST + "/users/login";

    // 课程管理接口 - 获取推荐课程
    public static final String API_COURSES_BOUTIQUE = HOST + "/courses/getBoutiqueCourse";

    // 文章管理接口 - 文章列表
    public static final String API_ARTICLE_LIST = HOST + "/article/page";
}
