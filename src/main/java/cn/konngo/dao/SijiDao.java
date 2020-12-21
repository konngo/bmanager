package cn.konngo.dao;


import cn.konngo.entity.SijiEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SijiDao {

/**
*  查询所有
*/
@Select("select * from siji")
List<SijiEntity> list();

    /**
    * 根据id查询
    */
    @Select("select * from siji where id=#{id}")
    SijiEntity select(int id);

    /**
    * 删除
    */
    @Delete("delete from siji where id=#{id}")
    void delete(int id);

    /**
    * 更新
    */
    @Update("update siji set id=#{id},name=#{name},phone=#{phone},age=#{age} where id=#{id}")
    void update(SijiEntity sijiEntity);

    /**
    * 插入
    */
    @Insert("insert into siji values( #{name},#{phone},#{age})")
    void insert(SijiEntity sijiEntity);

    }