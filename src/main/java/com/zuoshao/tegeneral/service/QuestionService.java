package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.Index;
import com.zuoshao.tegeneral.bean.Relationship;
import com.zuoshao.tegeneral.bean.Studentclass;
import com.zuoshao.tegeneral.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @author zuoshao
 * @date 2019/9/24 - 12:06
 */
public interface QuestionService {

    //查询所有指标
    List<Map<String, Object>> getindexalltrue(Integer id);
    //查询该学生对应班级
    Studentclass getstudentclass(Studentclass studentclass);
    //查询该班级下的所有老师
    List<User> getclassteacher(Relationship relationship);
    //
}
