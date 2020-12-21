package cn.konngo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("login")
    public String login(){
        return "login";
    }


    @RequestMapping("toindex")
    public String index(){
        return "main";
    }

    @RequestMapping("userlogin")
    public String userlogin(){
        return "userlogin";
    }
}
