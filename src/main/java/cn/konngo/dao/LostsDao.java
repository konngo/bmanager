package cn.konngo.dao;

import cn.konngo.entity.LostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostsDao extends JpaRepository<LostsEntity,Integer> {

}