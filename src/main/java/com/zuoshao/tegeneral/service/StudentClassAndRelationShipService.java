package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.User;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/15 10:51
 * @VERSION: 1.0
 **/
public interface StudentClassAndRelationShipService {

    //返回未选择班级的学生用户
    List<User> selectstudents();
}
