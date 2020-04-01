package com.van589.mooc.web.ui.api;

/**
 * API类
 */
public class API {

    // 主机地址
    public static final String HOST = "http://localhost:8091/api/v1";

    // 用户管理接口 - 登录
    public static final String API_USERS_LOGIN = HOST + "/users/login";

    // 用户管理接口 - 注册
    public static final String API_USERS_REGISTER = HOST + "/users/register";

    // 用户管理接口 - 验证用户名
    public static final String API_USERS_CHECK_NAME = HOST + "/users/checkName";

    // 用户管理接口 - 编辑用户
    public static final String API_USERS_EDIT = HOST + "/users/edit";

    // 课程管理接口 - 获取推荐课程
    public static final String API_COURSES_BOUTIQUE = HOST + "/courses/getBoutiqueCourse";

    // 课程管理接口 - 获取搜索课程
    public static final String API_COURSES_SEARCH = HOST + "/courses/searchName";

    //课程管理接口 - 查看课程细节
    public static final String API_COURSES_DETAIL = HOST + "/courses/detail";

    // 文章管理接口 - 文章列表
    public static final String API_ARTICLE_LIST = HOST + "/article/page";

    // 文章管理接口 - 获取文章详情
    public static final String API_ARTICLE_DETAIL = HOST + "/article/detail";
}
