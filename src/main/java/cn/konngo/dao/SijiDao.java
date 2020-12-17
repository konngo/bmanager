package cn.konngo.dao;

import cn.konngo.entity.SijiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SijiDao extends JpaRepository<SijiEntity,Integer> {

}