package com.van589.mooc.web.ui.controller;

import com.van589.mooc.web.ui.api.API;
import com.van589.mooc.web.ui.api.ArticleAPI;
import com.van589.mooc.web.ui.api.CourseAPI;
import com.van589.mooc.web.ui.dto.Article;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "article")
public class ArticleController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String article() {
        return "article/article_main";
    }

    /**
     * 跳转视频中心页面
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String course(HttpServletRequest request) throws Exception {
        // 获取连接客户端工具
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String entityStr = null;
        CloseableHttpResponse response = null;
        //获取 DateTables 的请求的参数
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair pair1 = new BasicNameValuePair("draw", draw);
        BasicNameValuePair pair2 = new BasicNameValuePair("start", start);
        BasicNameValuePair pair3 = new BasicNameValuePair("length", length);
        list.add(pair1);
        list.add(pair2);
        list.add(pair3);

        URIBuilder uriBuilder = new URIBuilder(API.API_ARTICLE_LIST);
        uriBuilder.addParameters(list);
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        // 传输的类型
        httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");

        // 执行请求
        response = httpClient.execute(httpGet);
        // 获得响应的实体对象
        HttpEntity entity = response.getEntity();
        // 使用Apache提供的工具类进行转换成字符串
        entityStr = EntityUtils.toString(entity, "UTF-8");

        return entityStr;
    }
}
