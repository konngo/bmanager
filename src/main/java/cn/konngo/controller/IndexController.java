package cn.konngo.controller;

import cn.konngo.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @RequestMapping("login")
    public String login(){
        return "login";
    }


    @RequestMapping("/file-upload")
    @ResponseBody
    public Map upload(@RequestParam("file") MultipartFile file) {
        Map map=new HashMap();
        map.put("code","1");
        if (file.isEmpty()) {
            map.put("msg","请选择上传文件");
        }
        FileUploadUtil fileUploadUtil=new FileUploadUtil();
        String filename=fileUploadUtil.uploadFile(file);
        map.put("code","0");
        map.put("msg","上传成功");
        map.put("data",filename);
        return map;
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
    @RequestMapping("linelist")
    public String linelist(){
        return "linelist";
    }

    @RequestMapping("sijilist")
    public String sijilist(){
        return "sijilist";
    }

    @RequestMapping("buslines")
    public String buslines(){
        return "buslines";
    }


    @RequestMapping("lostlist")
    public String lostlist(){
        return "lostlist";
    }

    @RequestMapping("bus")
    public String bus(){
        return "bus";
    }

    @RequestMapping("losts")
    public String losts(){
        return "losts";
    }

    @RequestMapping("profile")
    public String profile(){
        return "profile";
    }

}
