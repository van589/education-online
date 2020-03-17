package com.van589.mooc.web.ui.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.van589.mooc.commons.utils.HttpClientUtils;
import com.van589.mooc.web.ui.dto.Article;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.List;

/**
 * 文章接口
 */
public class ArticleAPI {

    /**
     * 获取文章列表
     *
     * @return
     * @throws Exception
     */
    public static String getList(List list) throws Exception{
        String json = HttpClientUtils.doGet(API.API_ARTICLE_LIST);

        ObjectMapper mapper = new ObjectMapper();
        List<Article> readValue = mapper.readValue(json,new TypeReference<List<Article>>(){});
        return json;
    }
}
