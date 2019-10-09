package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.*;
import com.zuoshao.tegeneral.bean.Class;
import com.zuoshao.tegeneral.bean.beanexa.Querytionexa;
import com.zuoshao.tegeneral.service.BatchService;
import com.zuoshao.tegeneral.service.QuestionService;
import com.zuoshao.tegeneral.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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

@Api(value = "QuestionnaireController|一个用来对应试卷的控制器")
@Controller
public class QuestionnaireController {

    @Autowired
    QuestionService questionService;
    @Autowired
    BatchService batchService;

    Studentclass studentclass = new Studentclass();
    Map<String, Object> menuss = new HashMap<>();

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


        for (User user : users) {
            Querytionexa querytionexa = new Querytionexa();
            querytionexa.setState(1);
            querytionexa.setName(getbatchstate.getName());
            querytionexa.setQname("评价老师试卷");
            querytionexa.setTid(user.getId());
            querytionexa.setTname(user.getName());

            listss.add(querytionexa);
        }

        menuss.put("studentquestion", listss);
        menuss.put("code", 1);

        return menuss;
    }
}
