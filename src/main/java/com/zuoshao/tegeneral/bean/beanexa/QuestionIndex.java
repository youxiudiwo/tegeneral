package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/10/11 - 16:34
 */
public class QuestionIndex {
    @Column
    private Integer id;
    @Column
    private String title;
    @Column
    private List<Indexoption> problem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
