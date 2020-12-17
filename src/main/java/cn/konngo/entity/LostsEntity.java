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
        private int buslines;

        //司机
        private int siji;

    public LostsEntity() {
    }

    public LostsEntity(int id, String name, String content, int buslines, int siji) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.buslines = buslines;
        this.siji = siji;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBuslines() {
        return buslines;
    }

    public void setBuslines(int buslines) {
        this.buslines = buslines;
    }

    public int getSiji() {
        return siji;
    }

    public void setSiji(int siji) {
        this.siji = siji;
    }
}
