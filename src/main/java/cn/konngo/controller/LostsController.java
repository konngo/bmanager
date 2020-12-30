package cn.konngo.controller;

import cn.konngo.entity.LostsEntity;
import cn.konngo.dao.LostsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/losts")
public class LostsController {
    @Autowired
    LostsDao lostsDao;

    @RequestMapping("list")
    @ResponseBody
    public Map searchAll(String siji,String buslines,String losts){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List<LostsEntity> list=lostsDao.findAll(siji,buslines,losts);
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
        public boolean delte(int id){
        lostsDao.delete(id);
        return true;
    }

    @RequestMapping("addOrUpdate")
    public String  saveOrUpdate(LostsEntity lostsEntity){
        if (lostsEntity.getId()==0||(""+lostsEntity.getId()).equals("")){
            lostsDao.insert(lostsEntity);
        }else {
            lostsDao.update(lostsEntity);
        }
        return "losts";
    }


    @RequestMapping("page")
    public String page(){
         return "losts";
    }
}
