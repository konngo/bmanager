package cn.konngo.dao;

import cn.konngo.entity.LostsEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LostsDao {

    /**
     *  查询所有
     */
    @Select("select * from losts")
    List<LostsEntity> list();

    /**
     * 根据id查询
     */
    @Select("select * from losts where id=#{id}")
    LostsEntity select(int id);

    /**
     * 删除
     */
    @Delete("delete from losts where id=#{id}")
    void delete(int id);

    /**
     * 更新
     */
    @Update("update losts set id=#{id},name=#{name},content=#{content},buslines=#{buslines},siji=#{siji} where id=#{id}")
    void update(LostsEntity lostsEntity);

    /**
     * 插入
     */
    @Insert("insert into losts (name,content,buslines,siji) values( #{name},#{content},#{buslines},#{siji})")
    void insert(LostsEntity lostsEntity);

    /**
     *  模糊查询
     */
    @Select("<script>" +
            "select l.* from " +
            "losts l join siji s on l.siji=s.id join buslines b on l.buslines=b.id  " +
            "where 1=1 " +
            " <if test='siji != null'> and s.name like  CONCAT('%',#{siji},'%')  </if> " +
            " <if test='buslines!=null'> and b.startstation like CONCAT('%',#{buslines},'%')  </if>" +
            " <if test='losts!=null'> and l.name like CONCAT('%',#{losts},'%')  </if>" +
            "</script>" )
    List<LostsEntity> findAll( String siji, String buslines,String losts);

}