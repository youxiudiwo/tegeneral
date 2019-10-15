package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Batch;
import com.zuoshao.tegeneral.bean.Option;
import com.zuoshao.tegeneral.bean.Score;
import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.bean.beanexa.Pjtjbean;
import com.zuoshao.tegeneral.bean.beanexa.QuestionType;
import com.zuoshao.tegeneral.bean.beanexa.ScoreSelect;
import com.zuoshao.tegeneral.service.BatchService;
import com.zuoshao.tegeneral.service.CollegeService;
import com.zuoshao.tegeneral.service.ScoreService;
import com.zuoshao.tegeneral.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author zuoshao
 * @date 2019/10/12 - 16:45
 */
@Controller
@Api(description = "评教统计")
public class ScoretowController  {

    @Autowired
    ScoreService scoreService;
    @Autowired
    UserService userService;
    @Autowired
    BatchService batchService;
    @Autowired
    CollegeService collegeService;

    @RequestMapping("/getpjtj")
    @ResponseBody
    @ApiOperation(value = "获取评教统计信息",httpMethod = "GET")
    public Map score(){

        float sum = 0;
        List<Pjtjbean> getpjtj = scoreService.getpjtj();


        for (Pjtjbean pj:getpjtj) {
            User user = new User();
            user.setId(pj.getUid());
            User s = userService.userlogin(user);
            List<Score> as = scoreService.selectScore1(s.getId(),pj.getBid());
            for(Integer i = 0;i < as.size();i++){
                sum = sum + Float.parseFloat(as.get(i).getScores());
            }
            String Average = String.valueOf(sum/as.size());
            pj.setFraction(Average);
            sum = 0;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("pjtj",getpjtj);
        return map;
    }

    @RequestMapping("/getpjtjexa")
    @ResponseBody
    @ApiOperation(value = "评教统计信息搜索",httpMethod = "POST")
    @ApiImplicitParam(paramType="query", name = "exa", value = "搜索信息", required = true, dataType = "String")
    public Map score(@RequestParam("exa")String exa) {
        float sum = 0;
        User user = new User();
        user.setName(exa);
        List<Pjtjbean> getpjtjexa = scoreService.getpjtjexa(user);

        for (Pjtjbean pj:getpjtjexa) {
            User user2 = new User();
            user2.setId(pj.getUid());
            User s = userService.userlogin(user2);
            List<Score> as = scoreService.selectScore1(s.getId(),pj.getBid());
            for(Integer i = 0;i < as.size();i++){
                sum = sum + Float.parseFloat(as.get(i).getScores());
            }
            String Average = String.valueOf(sum/as.size());
            pj.setFraction(Average);
            sum = 0;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("pjtjexa",getpjtjexa);
        return map;
    }

    @RequestMapping("/getquestiontypetj")
    @ResponseBody
    @ApiOperation(value = "评教统计分类返回", httpMethod = "POST")
    @ApiImplicitParam(paramType = "query", name = "username", value = "用户信息", required = true, dataType = "String")
    public Map getquestiontypetj(@RequestParam("username") String username) {

        User user = new User();
        user.setUsername(username);
        User userlogin = userService.userlogin(user);

        Option option = new Option();
        option.setId(userlogin.getId());

        List<QuestionType> getquestiontypetj = scoreService.getquestiontypetj(option);
        List<ScoreSelect> lists = new ArrayList<>();
        Map result = new HashMap();


        for (QuestionType qu : getquestiontypetj) {
            ScoreSelect scoreSelect = new ScoreSelect();
            scoreSelect.setName(qu.getQname());
            scoreSelect.setScore(qu.getScores());
            lists.add(scoreSelect);
        }
        float sum = 0;
        double score = 0;
        for (int i = 0; i < lists.size() ; i++) {
            sum = sum + lists.get(i).getScore();
        }
        score = sum / lists.size();
        String batch = getquestiontypetj.get(0).getBname();
        Integer id = userlogin.getCollid();
        String collegeName = collegeService.selectCollegeName(id);
        result.put("collegeName",collegeName);
        result.put("batch",batch);
        result.put("score",score);
        result.put("data",lists);
        return result;
    }

    }
