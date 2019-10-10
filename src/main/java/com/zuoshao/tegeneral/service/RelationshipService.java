package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.Class;
import com.zuoshao.tegeneral.bean.Relationship;
import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.bean.beanexa.RelationShipmapping;
import com.zuoshao.tegeneral.bean.beanexa.StudentClass;

import javax.management.relation.Relation;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/9/20 - 12:00
 */
public interface RelationshipService {
    //获取授课关系信息
    List<RelationShipmapping> getrelationship();
    //匹配查询一老师的授课信息
    List<RelationShipmapping> getrelationshipasexa(User user);
    //获取学生班级关系信息
    List<StudentClass> getstudentclass();
    //获取所有的班级
    List<Class> getclassall();
    //匹配学生班级信息
    List<StudentClass> getstudentclassasexa(User user);
    //查询当前老师所在的学院
    List<Relationship> getteacherrelationship(Relationship relationship);
    //获取当前学院的所有老师
    List<Relationship> getcollegeteacher(Relationship relationship);
}
