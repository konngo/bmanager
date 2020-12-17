package cn.konngo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
  *  线路
  */

@Data
@ToString
@Entity
@Table(name = "buslines")
public class BuslinesEntity implements Serializable {

    @Id
        //编号
        private int id;

        //起点站
        private String startstation;

        //终点站
        private String endstation;

        //发车时间
        private String starttime;

        //到站时间
        private String endtime;


}
