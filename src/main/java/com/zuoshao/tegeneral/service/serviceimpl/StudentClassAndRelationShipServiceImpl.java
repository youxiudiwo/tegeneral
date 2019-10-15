package com.zuoshao.tegeneral.service.serviceimpl;

import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.mapper.StudentClassAndRelationShipMapper;
import com.zuoshao.tegeneral.service.StudentClassAndRelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/15 10:52
 * @VERSION: 1.0
 **/
@Service
public class StudentClassAndRelationShipServiceImpl implements StudentClassAndRelationShipService {
    @Autowired
    private StudentClassAndRelationShipMapper studentClassAndRelationShipMapper;

    @Override
    public List<User> selectstudents() {
        return studentClassAndRelationShipMapper.selectstudents();
    }
}
