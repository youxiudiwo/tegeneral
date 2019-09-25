package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author zuoshao
 * @date 2019/9/24 - 8:35
 */
public class StudentClass {
    @Id
    @Column
    private Integer id;
    @Column
    private String username;
    @Column
    private String stname;
    @Column
    private String clname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname;
    }
}
