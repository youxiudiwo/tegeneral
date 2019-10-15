package com.zuoshao.tegeneral.bean.beanexa;

import javax.persistence.Column;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/15 13:39
 * @VERSION: 1.0
 **/

public class StudentsClass {
    @Column
    private List<ClassStudents> studentsClass;

    public List<ClassStudents> getStudentsClass() {
        return studentsClass;
    }

    public void setStudentsClass(List<ClassStudents> studentsClass) {
        this.studentsClass = studentsClass;
    }
}
