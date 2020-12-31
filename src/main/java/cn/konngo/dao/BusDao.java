package cn.konngo.dao;


import cn.konngo.entity.BusEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BusDao {

/**
*  查询所有
*/
@Select("select * from bus")
List<BusEntity> list();

    /**
    * 根据id查询
    */
    @Select("select * from bus where id=#{id}")
    BusEntity select(int id);

    /**
    * 删除
    */
    @Delete("delete from bus where id=#{id}")
    void delete(int id);

    /**
    * 更新
    */
    @Update("update bus set id=#{id},name=#{name},types=#{types},siji=#{siji},buslines=#{buslines} where id=#{id}")
    void update(BusEntity busEntity);

    /**
    * 插入
    */
    @Insert("insert into bus(name,types,siji,buslines) values(#{name},#{types},#{siji},#{buslines} )")
    void insert(BusEntity busEntity);

    }