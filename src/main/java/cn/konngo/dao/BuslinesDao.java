package cn.konngo.dao;

import cn.konngo.entity.BuslinesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuslinesDao extends JpaRepository<BuslinesEntity,Integer> {

}