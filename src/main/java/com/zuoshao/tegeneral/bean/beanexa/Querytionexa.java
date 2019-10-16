package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;

/**
 * @author zuoshao
 * @date 2019/10/8 - 15:37
 */
public class Querytionexa {
    @Column
    private Integer bid;
    @Column
    private String name;
    @Column
    private  Integer state;
    @Column
    private Integer qid;
    @Column
    private  String qname;
    @Column
    private String tname;
    @Column
    private Integer tid;
    @Column
    private Integer qstate;


    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getQstate() {
        return qstate;
    }

    public void setQstate(Integer qstate) {
        this.qstate = qstate;
    }
}
