package com.zuoshao.tegeneral.bean;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author zuoshao
 * @date 2019/9/9 - 9:21
 */
public class General {
    @Id
    @Column
    private Integer id;
    @Column
    private Integer userid;
    @Column
    private Integer userid2;
    @Column
    private Integer quid;
    @Column
    private Integer opid;
    @Column
    private Integer inid;
    @Column
    private Integer batch;
    @Column
    private String fraction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid2() {
        return userid2;
    }

    public void setUserid2(Integer userid2) {
        this.userid2 = userid2;
    }

    public Integer getQuid() {
        return quid;
    }

    public void setQuid(Integer quid) {
        this.quid = quid;
    }

    public Integer getOpid() {
        return opid;
    }

    public void setOpid(Integer opid) {
        this.opid = opid;
    }

    public Integer getInid() {
        return inid;
    }

    public void setInid(Integer inid) {
        this.inid = inid;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }
}
