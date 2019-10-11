package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/11 17:26
 * @VERSION: 1.0
 **/

public class ScoreAdd {
    @Column
    private String name;//评分人姓名
    @Column
    private Integer tid;//被评分人的ID
    @Column
    private Integer id;//试卷ID
    @Column
    private Integer bid;//批次ID
    @Column
    private List<Problem> problem;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public List<Problem> getProblem() {
        return problem;
    }

    public void setProblem(List<Problem> problem) {
        this.problem = problem;
    }
}
