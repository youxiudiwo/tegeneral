package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.*;
import com.zuoshao.tegeneral.bean.Class;
import com.zuoshao.tegeneral.bean.beanexa.Querytionexa;
import com.zuoshao.tegeneral.bean.beanexa.QustionBatch;
import com.zuoshao.tegeneral.service.BatchService;
import com.zuoshao.tegeneral.service.QuestionService;
import com.zuoshao.tegeneral.service.RelationshipService;
import com.zuoshao.tegeneral.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zuoshao
 * @date 2019/10/8 - 9:43
 */

@Api(description = "试卷管理接口",value = "QuestionnaireController|一个用来对应试卷的控制器")
@Controller
public class QuestionnaireController {


    @Autowired
    QuestionService questionService;
    @Autowired
    BatchService batchService;
    @Autowired
    RelationshipService relationshipservice;
    @Autowired
    UserService userService;

    Studentclass studentclass = new Studentclass();
    Map<String, Object> menuss = new HashMap<>();

    @ApiOperation(value="获取所有试卷信息", notes="获取当前所有试卷信息")
    @RequestMapping("/getquestion")
    @ResponseBody
    public Map<String,Object> getquestionall(){
        List<QustionBatch> getquestionall = questionService.getquestionall();
        menuss.put("questionall", getquestionall);
        menuss.put("code", 1);
        return menuss;
    }


    @ApiOperation(value="根据当前登陆学生获取评价老师试卷信息", notes="test: 1有正确返回0表示当前批次没有状态为开启的试卷")
    @ApiImplicitParam(paramType="query", name = "studentid", value = "学生id", required = true, dataType = "int")
    @RequestMapping("/getstudentquestionnaire")
    @ResponseBody
    public Map<String,Object> getstudentclassasexa(@RequestParam("studentid")Integer studentid) {

        studentclass.setStudentid(studentid);
        Studentclass getstudentclassid = questionService.getstudentclass(studentclass);
        Relationship relationship = new Relationship();
        relationship.setClassid(getstudentclassid.getClassid());
        List<User> users = questionService.getclassteacher(relationship);
        List<Querytionexa> listss = new ArrayList<>();
        Batch batch = new Batch();
        batch.setState(1);
        Batch getbatchstate = batchService.getbatchstate(batch);

        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setBatch(getbatchstate.getId());
        questionnaire.setName("评价老师");

        Questionnaire getqeustionexa = questionService.getqeustionexa(questionnaire);

        for (User user : users) {
            Querytionexa querytionexa = new Querytionexa();
            querytionexa.setState(1);
            querytionexa.setName(getbatchstate.getName());
            querytionexa.setQid(getqeustionexa.getId());
            querytionexa.setQname(getqeustionexa.getName());
            querytionexa.setTid(user.getId());
            querytionexa.setTname(user.getName());

            listss.add(querytionexa);
        }

        menuss.put("studentquestion", listss);
        menuss.put("code", 1);

        return menuss;
    }


    @ApiOperation(value="根据当前登陆老师获取评价同行试卷信息", notes="test: 1有正确返回0表示当前批次没有状态为开启的试卷")
    @ApiImplicitParam(paramType="query", name = "teacherid", value = "用户id", required = true, dataType = "int")
    @RequestMapping("/getteacherquestionnaire")
    @ResponseBody
    public Map<String,Object> getteacherquestionnaire(@RequestParam("teacherid")Integer teacherid) {

        //查询当前老师所在的学院中所有同行老师
        Relationship relationship = new Relationship();
        relationship.setTeacherid(teacherid);
        List<Relationship> list1 = relationshipservice.getteacherrelationship(relationship);
        Integer collegeid =  list1.get(0).getCollegeid();
        Relationship relationship2 = new Relationship();
        relationship2.setCollegeid(collegeid);
        List<Relationship> getcollegeteacher = relationshipservice.getcollegeteacher(relationship2);
        //循环封装成试卷格式
//        new
//        for (Relationship re:getcollegeteacher) {
//            userService.selectuserforid()
//        }

        return menuss;
    }

}
