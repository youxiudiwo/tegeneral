package com.zuoshao.tegeneral.mapper;

import com.zuoshao.tegeneral.bean.Curriculum;
import com.zuoshao.tegeneral.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/15 10:50
 * @VERSION: 1.0
 **/
@Repository
public interface StudentClassAndRelationShipMapper {

    List<User> selectstudents();
    List<User> selectAllTeacher();
    List<Curriculum> selectAllCurriculum();
}
