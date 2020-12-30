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
        List list=sijiDao.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
    public HashMap delte(int id){
        HashMap map=new HashMap();
        map.put("code","0");
        sijiDao.delete(id);
        return map;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    public HashMap  saveOrUpdate(SijiEntity sijiEntity){
        HashMap map=new HashMap();
        map.put("code","0");
        if (sijiEntity.getId()==0||(""+sijiEntity.getId()).equals("")){
            sijiDao.insert(sijiEntity);
        }else {
            sijiDao.update(sijiEntity);
        }
        return map;
    }


    @RequestMapping("page")
    public String page(){
         return "siji";
    }
}
