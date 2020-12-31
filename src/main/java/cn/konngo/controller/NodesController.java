package cn.konngo.controller;


import cn.konngo.dao.NodesDao;
import cn.konngo.entity.NodesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/nodes")
public class NodesController {

    @Autowired
    NodesDao nodesDao;


    @RequestMapping("list")
    @ResponseBody
    public Map searchAll(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=nodesDao.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
    public HashMap delte(int id){
        HashMap map=new HashMap();
        map.put("code","0");
        nodesDao.delete(id);
        return map;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    public HashMap  saveOrUpdate(NodesEntity sijiEntity){
        HashMap map=new HashMap();
        map.put("code","0");
        if (sijiEntity.getId()==0||(""+sijiEntity.getId()).equals("")){
            nodesDao.insert(sijiEntity);
        }else {
            nodesDao.update(sijiEntity);
        }
        return map;
    }


    @RequestMapping("page")
    public String page(){
        return "siji";
    }

}
