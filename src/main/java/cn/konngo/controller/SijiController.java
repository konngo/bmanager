package cn.konngo.controller;

import cn.konngo.entity.SijiEntity;
import cn.konngo.dao.SijiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/siji")
public class SijiController {
    @Autowired
    SijiDao sijiDao;

    @RequestMapping("list")
    @ResponseBody
    public Map searchAll(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=sijiDao.findAll();
        map.put("count",list.size());
        map.put("data",list);
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
        public boolean delte(int id){
        sijiDao.deleteById(id);
        return true;
    }

    @RequestMapping("addOrUpdate")
    public String  saveOrUpdate(SijiEntity sijiEntity){
        sijiDao.save(sijiEntity);
        return "siji";
    }


    @RequestMapping("page")
    public String page(){
         return "siji";
    }
}
