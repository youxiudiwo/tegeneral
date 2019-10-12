package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;

/**
 * @author zuoshao
 * @date 2019/10/12 - 17:05
 */
public class Pjtjbean {
    @Column
    private  String uname;
    @Column
    private String cname;
    @Column
    private String bname;
    @Column
    private Integer uid;
    @Column
    private Integer bid;
    @Column
    private String fraction;


    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
