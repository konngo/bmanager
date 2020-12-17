package cn.konngo.dao;

import cn.konngo.entity.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusDao extends JpaRepository<BusEntity,Integer> {

}