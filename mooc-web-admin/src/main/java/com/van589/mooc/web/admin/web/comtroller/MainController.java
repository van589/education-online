package com.van589.mooc.web.admin.web.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(){
        return "user/user_list";
    }
}
