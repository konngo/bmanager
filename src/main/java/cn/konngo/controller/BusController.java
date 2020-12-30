package cn.konngo.controller;

import cn.konngo.entity.BusEntity;
import cn.konngo.dao.BusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bus")
public class BusController {
    @Autowired
    BusDao busDao;

    @RequestMapping("list")
    @ResponseBody
    public Map searchAll(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=busDao.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
        public boolean delte(int id){
        busDao.delete(id);
        return true;
    }

    @RequestMapping("addOrUpdate")
    public String  saveOrUpdate(BusEntity busEntity){
        if (busEntity.getId()==0||(""+busEntity.getId()).equals("")){
            busDao.insert(busEntity);
        }else {
            busDao.update(busEntity);
        }
        return "bus";
    }


    @RequestMapping("page")
    public String page(){
         return "bus";
    }
}
