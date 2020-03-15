package com.van589.mooc.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "article")
public class ArticleController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String article(){
        return "article/article_main";
    }
}
