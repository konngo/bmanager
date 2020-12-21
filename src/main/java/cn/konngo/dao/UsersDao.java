package cn.konngo.dao;


import cn.konngo.entity.UsersEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersDao {

    /**
    *  查询所有
    */
    @Select("select * from users")
    List<UsersEntity> list();

    /**
    * 根据id查询
    */
    @Select("select * from users where id=#{id}")
    UsersEntity select(int id);

    /**
    * 删除
    */
    @Delete("delete from users where id=#{id}")
    void delete(int id);

    /**
    * 更新
    */
    @Update("update users set id=#{id},username=#{username},password=#{password},nickname=#{nickname},type=#{type} where id=#{id}")
    void update(UsersEntity usersEntity);

    /**
    * 插入
    */
    @Insert("insert into users values(#{username},#{password},#{nickname},#{type})")
    void insert(UsersEntity usersEntity);

    @Select("select * from users where  username=#{username} and password=#{password}")
    UsersEntity login(String username, String password);
}