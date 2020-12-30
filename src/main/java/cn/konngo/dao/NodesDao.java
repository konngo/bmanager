package cn.konngo.dao;

import cn.konngo.entity.NodesEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NodesDao {
    /**
     *  查询所有
     */
    @Select("select * from nodes")
    List<NodesEntity> list();

    /**
     * 根据id查询
     */
    @Select("select * from nodes where id=#{id}")
    NodesEntity select(int id);

    /**
     * 删除
     */
    @Delete("delete from nodes where id=#{id}")
    void delete(int id);

    /**
     * 更新
     */
    @Update("update nodes set name=#{name} where id=#{id}")
    void update(NodesEntity sijiEntity);

    /**
     * 插入
     */
    @Insert("insert into nodes values(#{name})")
    void insert(NodesEntity sijiEntity);

}
