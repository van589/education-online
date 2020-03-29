package com.van589.mooc.web.ui.api;

import com.van589.mooc.commons.dto.BaseResult;
import com.van589.mooc.commons.utils.HttpClientUtils;
import com.van589.mooc.commons.utils.MapperUtils;
import com.van589.mooc.web.ui.dto.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理接口
 */
public class UserAPI {

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public static User login(User user) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name", user.getName()));
        params.add(new BasicNameValuePair("password", user.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        user = MapperUtils.json2pojoByTree(json, "data", User.class);
        return user;
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    public static BaseResult register(User user) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name", user.getName()));
        params.add(new BasicNameValuePair("nickname", user.getNickname()));
        params.add(new BasicNameValuePair("password", user.getPassword()));
        params.add(new BasicNameValuePair("sex", user.getSex()));
        params.add(new BasicNameValuePair("phone", user.getPhone()));
        params.add(new BasicNameValuePair("email", user.getEmail()));
        params.add(new BasicNameValuePair("wechar", StringUtils.isEmpty(user.getWechar()) ? null : user.getWechar()));
        params.add(new BasicNameValuePair("education", user.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_REGISTER, params.toArray(new BasicNameValuePair[params.size()]));
        BaseResult baseResult = MapperUtils.json2pojo(json, BaseResult.class);
        return baseResult;
    }

    /**
     * 检查用户名是否存在
     *
     * @param name
     * @return
     * @throws Exception
     */
    public static BaseResult checkName(String name) throws Exception {
        String json = HttpClientUtils.doGet(API.API_USERS_CHECK_NAME + "?name=" + name);
        BaseResult baseResult = MapperUtils.json2pojo(json, BaseResult.class);
        return baseResult;
    }

    /**
     * 编辑用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    public static BaseResult edit(User user) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name", user.getName()));
        params.add(new BasicNameValuePair("nickname", user.getNickname()));
        params.add(new BasicNameValuePair("password", user.getPassword()));
        params.add(new BasicNameValuePair("sex", user.getSex()));
        params.add(new BasicNameValuePair("phone", user.getPhone()));
        params.add(new BasicNameValuePair("email", user.getEmail()));
        params.add(new BasicNameValuePair("wechar", StringUtils.isEmpty(user.getWechar()) ? null : user.getWechar()));
        params.add(new BasicNameValuePair("education", user.getPassword()));
        String json = HttpClientUtils.doPost(API.API_USERS_EDIT, params.toArray(new BasicNameValuePair[params.size()]));
        BaseResult baseResult = MapperUtils.json2pojo(json, BaseResult.class);
        return baseResult;
    }

}
