package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;

/**
 * @Author: luquanlin
 * @Date: 2019/10/11 17:41
 * @VERSION: 1.0
 **/

public class Problem {
    @Column
    private Integer id;//指标ID
    @Column
    private String title;//指标名称
    @Column
    private Integer click;//当前指标所选的选项

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

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }
}
