package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;

/**
 * @author zuoshao
 * @date 2019/10/10 - 10:53
 */
public class QustionBatch {

    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String batchid;
    @Column
    private String batch;
    @Column
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatchid() {
        return batchid;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
