package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Batch;
import com.zuoshao.tegeneral.bean.Score;
import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.bean.beanexa.Pjtjbean;
import com.zuoshao.tegeneral.service.BatchService;
import com.zuoshao.tegeneral.service.ScoreService;
import com.zuoshao.tegeneral.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
