package cn.konngo.controller;

import cn.konngo.entity.BuslinesEntity;
import cn.konngo.dao.BuslinesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/buslines")
public class BuslinesController {
    @Autowired
    BuslinesDao buslinesDao;

    @RequestMapping("list")
    @ResponseBody
    public Map searchAll(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=buslinesDao.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
        public HashMap delte(int id){

        HashMap map=new HashMap();
        map.put("code","0");
        buslinesDao.delete(id);
        return map;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    public HashMap  saveOrUpdate(BuslinesEntity buslinesEntity){
        HashMap map=new HashMap();
        map.put("code","0");
        if (buslinesEntity.getId()==0||(""+buslinesEntity.getId()).equals("")){
            buslinesDao.insert(buslinesEntity);
        }else {
            buslinesDao.update(buslinesEntity);
        }
        return map;
    }


    @RequestMapping("page")
    public String page(){
         return "buslines";
    }
}
