package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author zuoshao
 * @date 2019/9/22 - 10:28
 */
public class RoleMenu {
    @Id
    @Column
    private String role;
    @Column
    private String menu;
    @Column
    private String img;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
