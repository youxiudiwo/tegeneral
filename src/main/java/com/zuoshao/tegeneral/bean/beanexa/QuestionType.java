package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;

/**
 * @author zuoshao
 * @date 2019/10/14 - 9:41
 */
public class QuestionType {
    @Column
    private Integer id;
    @Column
    private String bname;
    @Column
    private Float scores;
    @Column
    private String qname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }


    public Float getScores() {
        return scores;
    }

    public void setScores(Float scores) {
        this.scores = scores;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }
}
