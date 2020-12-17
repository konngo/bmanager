package cn.konngo.dao;

import cn.konngo.entity.LostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LostsDao extends JpaRepository<LostsEntity,Integer> {

    @Query("select new LostsEntity(l.id,l.name,l.content,l.siji,l.buslines) from " +
            "LostsEntity l join SijiEntity s on l.siji=s.id join BuslinesEntity b on l.buslines=b.id  " +
            "where 1=1 and (s.name like CONCAT('%',:siji,'%') or :siji IS NULL ) " +
            " and (b.startstation like CONCAT('%',:buslines,'%') or :buslines IS NULL ) " +
            " and (l.name like CONCAT('%',:losts,'%') or :losts IS NULL ) " )
    List<LostsEntity> findAll(@Param("siji") String siji, @Param("buslines") String buslines,@Param("losts")  String losts);
}