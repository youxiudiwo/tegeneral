package com.zuoshao.tegeneral.bean;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author zuoshao
 * @date 2019/9/9 - 9:21
 */
public class Score {
    @Id
    @Column
    private Integer id;
    @Column
    private Integer userid;
    @Column
    private String scores;
    @Column
    private Integer batch;
    @Column
    private Integer question;
    @Column
    private Integer userid2;

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

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public Integer getUserid2() {
        return userid2;
    }


    public void setUserid2(Integer userid2) {
        this.userid2 = userid2;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }
}
