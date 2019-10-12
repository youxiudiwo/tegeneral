package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.*;
import com.zuoshao.tegeneral.bean.beanexa.Querytionexa;
import com.zuoshao.tegeneral.bean.beanexa.QustionBatch;

import java.util.List;
import java.util.Map;

/**
 * @author zuoshao
 * @date 2019/9/24 - 12:06
 */
public interface QuestionService {

    //查询该学生对应班级
    Studentclass getstudentclass(Studentclass studentclass);
    //查询该班级下的所有老师
    List<User> getclassteacher(Relationship relationship);
    //根据传入的名称查询相关试卷（传入对应批次和试卷名称得到当前批次的该试卷）
    Questionnaire getqeustionexa(Questionnaire questionnaire);
    //查询所有的试卷
    List<QustionBatch> getquestionall();

    //插入一张试卷
    Integer addquestion(Questionnaire questionnaire);
    //查询一张试卷
    Questionnaire getaquestion(Questionnaire questionnaire);
    List<Questionnaire> getallquestion(Questionnaire questionnaire);

    //返回最新插入的试卷
    Questionnaire selectnewupdate();

    //插入试卷返回id
    Questionnaire insertquestion(Questionnaire questionnaire);

    //插入试卷和标题关联
    Integer addquestionindex(QuIn quin);
}
