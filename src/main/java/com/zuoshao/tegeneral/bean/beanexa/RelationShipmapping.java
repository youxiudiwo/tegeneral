package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author zuoshao
 * @date 2019/9/23 - 8:57
 */
public class RelationShipmapping {
    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String classname;
    @Column
    private String curr;
    @Column
    private String college;

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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
