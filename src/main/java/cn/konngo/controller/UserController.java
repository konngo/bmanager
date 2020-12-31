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
        map.put("aaData",list);
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
    public HashMap delte(int id){
        HashMap map=new HashMap();
        map.put("code","0");
        usersDao.delete(id);
        return map;
    }


    @RequestMapping("addOrUpdate")
    @ResponseBody
    public HashMap  saveOrUpdate(UsersEntity usersEntity){
        HashMap map=new HashMap();
        map.put("code","0");
       // usersDao.insert(usersEntity);
        if (usersEntity.getId()==0||(""+usersEntity.getId()).equals("")){
            usersDao.insert(usersEntity);
        }else {
            usersDao.update(usersEntity);
        }
        return map;
    }

    @RequestMapping("page")
    public String page(){
        return "users";
    }

   @RequestMapping("userreg")
   @ResponseBody
    public HashMap userreg(UsersEntity usersEntity){
       System.out.println(usersEntity);
        HashMap map=new HashMap();
        int i=usersDao.insert(usersEntity);
       if (i>0){
           map.put("code",0);
       }else {
           map.put("code",1);
       }
       return map;
    }




    @RequestMapping("login")
    @ResponseBody
    public HashMap login(UsersEntity u,HttpServletRequest request){
        System.out.println(u.getUsername()+u.getPassword());
        HashMap map=new HashMap();
        UsersEntity user=usersDao.login(u.getUsername(),u.getPassword());
        map.put("users",user);
        if (user!=null){
            map.put("code",0);
        }else {
            map.put("code",1);
        }
        return map;
    }



    @RequestMapping("search")
    @ResponseBody
    public HashMap search(int id,HttpServletRequest request){
        HashMap map=new HashMap();
        UsersEntity user=usersDao.serach(id);
        map.put("users",user);
        if (user!=null){
            map.put("code",0);
        }else {
            map.put("code",1);
        }
        return map;
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
