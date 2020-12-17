package cn.konngo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
  *  失物招领
  */

@Data
@ToString
@Entity
@Table(name = "losts")
public class LostsEntity implements Serializable {

    @Id
        //编号
        private int id;

        //名称
        private String name;

        //内容
        private String content;

        //线路
        private int lines;

        //司机
        private int siji;


}
