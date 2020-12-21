package cn.konngo.controller;

import cn.konngo.dao.UsersDao;
import cn.konngo.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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
        List list=usersDao.list();
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }

    @RequestMapping("resetpwd")
    @ResponseBody
    public Map resetpwd(String oldpwd, String newpwd, HttpServletRequest request){
        UsersEntity user= (UsersEntity) request.getSession().getAttribute("users");
        Map map=new HashMap();
        map.put("code","0");
        map.put("count",0);
        if (user.getPassword().equals(oldpwd)){
            user.setPassword(newpwd);
            usersDao.update(user);
            request.getSession().setAttribute("users",user);
            map.put("data",1);
            map.put("msg","用户密码已经修改完成");
        }else {
            map.put("data",0);
            map.put("msg","用户密码错误，请重试");
        }
        return map;
    }


    @RequestMapping("delete")
    @ResponseBody
    public boolean delte(int id){
        usersDao.delete(id);
        return true;
    }


    @RequestMapping("addOrUpdate")
    public String  saveOrUpdate(UsersEntity usersEntity){
       // usersDao.insert(usersEntity);
        if (usersEntity.getId()==0||(""+usersEntity.getId()).equals("")){
            usersDao.insert(usersEntity);
        }else {
            usersDao.update(usersEntity);
        }
        return "users";
    }

    @RequestMapping("page")
    public String page(){
        return "users";
    }

   @RequestMapping("userreg")
    public String userreg(UsersEntity usersEntity){
        usersEntity.setNickname("未填写");
        usersEntity.setType("用户");
        usersDao.insert(usersEntity);
        return "userlogin";
    }





    @RequestMapping("login")
    public String login(String username,String password,HttpServletRequest request){
        UsersEntity user=null;
        List<UsersEntity> list=usersDao.list();
        for (UsersEntity u:list) {
            if (u.getUsername().equals(username)&&password.equals(u.getPassword())){
                if (!u.getType().equals("管理员")){
                    break;
                }
                user=u;
                request.getSession().setAttribute("users",u);
            }
        }
        if (user!=null){
            return "index";
        }else {
            return "login";
        }
    }

    @RequestMapping("userlogin")
    public String userlogin(String username,String password,HttpServletRequest request){
        UsersEntity user=usersDao.login(username,password);
        if (user!=null){
            request.getSession().setAttribute("users",user);
            return "userindex";
        }else {
            return "userlogin";
        }
    }
}
