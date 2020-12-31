package cn.konngo.dao;


import cn.konngo.entity.BuslinesEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BuslinesDao {

/**
*  查询所有
*/
@Select("select * from buslines")
List<BuslinesEntity> list();

    /**
    * 根据id查询
    */
    @Select("select * from buslines where id=#{id}")
    BuslinesEntity select(int id);

    /**
    * 删除
    */
    @Delete("delete from buslines where id=#{id}")
    void delete(int id);

    /**
    * 更新
    */
    @Update("update buslines set id=#{id},startstation=#{startstation},endstation=#{endstation},starttime=#{starttime},endtime=#{endtime} where id=#{id}")
    void update(BuslinesEntity buslinesEntity);

    /**
    * 插入
    */
    @Insert("insert into buslines (startstation,endstation,starttime,endtime) values( #{startstation},#{endstation},#{starttime},#{endtime} )")
    void insert(BuslinesEntity buslinesEntity);

    }