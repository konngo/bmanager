package cn.konngo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
  *  司机
  */

@Data
@ToString
@Entity
@Table(name = "siji")
public class SijiEntity implements Serializable {

    @Id
        //编号
        private int id;

        //名称
        private String name;

        //手机号
        private String phone;

        //年龄
        private int age;


}
