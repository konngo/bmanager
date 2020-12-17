package cn.konngo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
  *  车辆
  */

@Data
@ToString
@Entity
@Table(name = "bus")
public class BusEntity implements Serializable {

    @Id
        //编号
        private int id;

        //名称
        private String name;

        //车辆型号
        private String types;

        //司机
        private int siji;

        //线路
        private int lines;


}
