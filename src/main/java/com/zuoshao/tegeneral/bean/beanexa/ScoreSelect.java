package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;

/**
 * @author zuoshao
 * @date 2019/10/14 - 10:06
 */
public class ScoreSelect {
    @Column
    private Float score;
    @Column
    private String name;

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
