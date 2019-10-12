package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/10/11 - 16:34
 */
public class QuestionIndex {
    @Column
    private String batch;
    @Column
    private String title;
    @Column
    private String type;
    @Column
    private List<Indexoption> problem;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Indexoption> getProblem() {
        return problem;
    }

    public void setProblem(List<Indexoption> problem) {
        this.problem = problem;
    }
}
