package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Score;
import com.zuoshao.tegeneral.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(description = "平均分统计")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @RequestMapping("/score")
    @ResponseBody
    @ApiOperation(value = "评价他人的分数统计",httpMethod = "POST")
    public Map score(@RequestParam Integer userid,@RequestParam Integer batch){     //用户id与学期id；
        Map reslut = new HashMap();
        List<Score> a = scoreService.selectScore(userid,batch);
        Integer sum = 0;
        for(int i = 0;i < a.size();i++){
            sum = sum + Integer.valueOf(a.get(i).getScores());
        }
        Integer Average = sum/a.size();
        reslut.put("Average",Average);
        return reslut;
    }

    @RequestMapping("/score1")
    @ResponseBody
    @ApiOperation(value = "被他人评价的分数统计",httpMethod = "POST")
    public Map score1(@RequestParam Integer userid2,@RequestParam Integer batch){     //用户id与学期id；
        Map reslut = new HashMap();
        List<Score> a = scoreService.selectScore1(userid2,batch);
        Integer sum = 0;
        for(int i = 0;i < a.size();i++){
            sum = sum + Integer.valueOf(a.get(i).getScores());
        }
        Integer Average = sum/a.size();
        reslut.put("Average",Average);
        return reslut;
    }
}
