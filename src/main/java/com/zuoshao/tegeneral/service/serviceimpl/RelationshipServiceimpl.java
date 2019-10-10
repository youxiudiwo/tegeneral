package com.zuoshao.tegeneral.service.serviceimpl;

import com.zuoshao.tegeneral.bean.Class;
import com.zuoshao.tegeneral.bean.Relationship;
import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.bean.beanexa.RelationShipmapping;
import com.zuoshao.tegeneral.bean.beanexa.StudentClass;
import com.zuoshao.tegeneral.mapper.ClassMapper;
import com.zuoshao.tegeneral.mapper.RelationshipMapper;
import com.zuoshao.tegeneral.mapper.Userrolemapper;
import com.zuoshao.tegeneral.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/9/20 - 12:04
 */
@Service
public class RelationshipServiceimpl implements RelationshipService {

    @Autowired
    Userrolemapper userrolemapper;
    @Autowired
    ClassMapper classmapper;
    @Autowired
    RelationshipMapper relationshipmapper;

    @Override
    public List<RelationShipmapping> getrelationship() {
        List<RelationShipmapping> selectrealationship = userrolemapper.selectrealationship();
        return selectrealationship;
    }

    @Override
    public List<RelationShipmapping> getrelationshipasexa(User user) {
        List<RelationShipmapping> selectrelationshipasexa = userrolemapper.selectrealationshipasexa(user);
        return selectrelationshipasexa;
    }

    @Override
    public List<StudentClass> getstudentclass() {
        List<StudentClass> selectstudentclass = userrolemapper.selectstudentclass();
        return selectstudentclass;
    }

    @Override
    public List<Class> getclassall() {
        List<Class> classes = classmapper.selectAll();
        return classes;
    }

    @Override
    public List<StudentClass> getstudentclassasexa(User user) {
        List<StudentClass> list = userrolemapper.selctclassstudentasexa(user);
        return list;
    }

    @Override
    public List<Relationship> getteacherrelationship(Relationship relationship) {
        List<Relationship> select = relationshipmapper.select(relationship);
        return select;
    }

    @Override
    public List<Relationship> getcollegeteacher(Relationship relationship) {
        List<Relationship> select = relationshipmapper.select(relationship);
        return select;
    }
}
