package com.zuoshao.tegeneral.bean.beanexa;

import com.zuoshao.tegeneral.bean.Option;

import javax.persistence.Column;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/10/11 - 14:53
 */
public class Indexoption {
    @Column
    private String name;
    @Column
    private String wight;
    @Column
    private Integer id;
    @Column
    private Integer sort;
    @Column
    private List<Option> option;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWight() {
        return wight;
    }

    public void setWight(String wight) {
        this.wight = wight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Option> getOption() {
        return option;
    }

    public void setOption(List<Option> option) {
        this.option = option;
    }
}
