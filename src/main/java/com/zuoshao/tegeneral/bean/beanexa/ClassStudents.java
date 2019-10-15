package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;

/**
 * @Author: luquanlin
 * @Date: 2019/10/15 14:30
 * @VERSION: 1.0
 **/

public class ClassStudents {
    @Column
    private Integer classid;
    @Column
    private Integer[] studentid;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer[] getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer[] studentid) {
        this.studentid = studentid;
    }
}
