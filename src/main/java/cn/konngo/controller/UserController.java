package cn.konngo.controller;

import cn.konngo.dao.UsersDao;
import cn.konngo.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    UsersDao usersDao;


    @RequestMapping("list")
    @ResponseBody
    public Map searchAll(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=usersDao.findAll();
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }


    @RequestMapping("delete")
    @ResponseBody
    public boolean delte(int id){
        usersDao.deleteById(id);
        return true;
    }


    @RequestMapping("addOrUpdate")
    public String  saveOrUpdate(UsersEntity usersEntity){
        usersDao.save(usersEntity);
        return "users";
    }

    @RequestMapping("page")
    public String page(){
        return "users";
    }


    @RequestMapping("login")
    public String login(String username,String password){
        UsersEntity user=null;
        List<UsersEntity> list=usersDao.findAll();
        for (UsersEntity u:list) {
            if (u.getUsername().equals(username)&&password.equals(u.getPassword())){
                user=u;
            }
        }
        if (user!=null){
            return "index";
        }else {
            return "login";
        }
    }
}
