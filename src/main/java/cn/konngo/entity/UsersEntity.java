package cn.konngo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
  *  用户
  */

@Data
@ToString
@Entity
@Table(name = "users")
public class UsersEntity implements Serializable {

    @Id
        //编号
        private int id;

        //用户名
        private String username;

        //密码
        private String password;

        //昵称
        private String nickname;


}
