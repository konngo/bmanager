package cn.konngo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("login")
    public String login(){
        return "login";
    }


    @RequestMapping("register")
    public String register(){
        return "register";
    }

    @RequestMapping("goindex")
    public String goindex(){
        return "index";
    }

    @RequestMapping("main")
    public String main(){
        return "main";
    }

    @RequestMapping("users")
    public String users(){
        return "users";
    }

    @RequestMapping("siji")
    public String siji(){
        return "siji";
    }

    @RequestMapping("buslines")
    public String buslines(){
        return "buslines";
    }

    @RequestMapping("bus")
    public String bus(){
        return "bus";
    }

    @RequestMapping("losts")
    public String losts(){
        return "losts";
    }

}
