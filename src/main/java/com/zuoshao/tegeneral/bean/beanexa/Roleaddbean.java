package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;

/**
 * @Author: luquanlin
 * @Date: 2019/10/15 13:39
 * @VERSION: 1.0
 **/

public class Roleaddbean {
    @Column
    private String rolename;
    @Column
    private Integer[] menu;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer[] getMenu() {
        return menu;
    }

    public void setMenu(Integer[] menu) {
        this.menu = menu;
    }
}
