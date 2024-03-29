package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Score;
import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.service.ScoreService;
import com.zuoshao.tegeneral.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@Api(description = "平均分统计")
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    @Autowired
    UserService userService;

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

    @RequestMapping("/scorepaihang")
    @ResponseBody
    @ApiOperation(value = "老师评价的分数统计排行",httpMethod = "POST")
    public Map scorepaihang(@RequestParam("batch")Integer batch) {

        float sum = 0;
        Map reslut = new HashMap();
        Score score = new Score();
        score.setBatch(batch);
        List<Score> scores = scoreService.selectallScore(score);
        Set<Integer> set = new TreeSet<>();
        List<Integer> a = new ArrayList<>();
        for (Score sc:scores) {
            set.add(sc.getUserid2());
        }
        List<String> userss= new ArrayList<>();

        for (Integer d:set) {
            User user = new User();
            user.setId(d);
            User s = userService.userlogin(user);
            List<Score> as = scoreService.selectScore1(s.getId(),batch);
            for(Integer i = 0;i < as.size();i++){
                sum = sum + Float.parseFloat(as.get(i).getScores());
            }
            String Average = String.valueOf(sum/as.size());
            userss.add(s.getName());
            userss.add(Average);
            sum = 0;
        }

         reslut.put("data",userss);
        return reslut;
    }

    @RequestMapping("/selectScoreTeacher")
    @ResponseBody
    @ApiOperation(value = "老师查看自己的每一期的平均分数",httpMethod = "POST")
    public Map selectScoreTeacher(@RequestParam("name")String name) {

//        User user = new User();
//        User user1 = userService.userlogin(user);
//        Integer id = user1.getId();
        Integer qq = scoreService.selectUserId(name);
        Integer id = qq;

        float sum = 0;
        Map reslut = new HashMap();
        List<Score> scores = scoreService.selectScoreTeacher(id);
        Set<Integer> set = new TreeSet<>();
        for (Score sc:scores) {
            set.add(sc.getBatch());
        }
        List<Map<String,Object>> avgs = new ArrayList<Map<String,Object>>();
        for (Integer s:set) {
            Map<String,Object> mm = new HashMap<String, Object>();
            List<Score> scores1 = scoreService.selectScore1(id,s);
            for (int i = 0; i < scores1.size() ; i++) {
               sum = sum + Float.parseFloat(scores1.get(i).getScores());
            }
            String Average = String.valueOf(sum/scores1.size());
            String name1 = scoreService.selectBatchName(s);
            sum = 0;
            mm.put("name",name1);
            mm.put("score",Average);
            avgs.add(mm);
        }
        reslut.put("data",avgs);
        return reslut;
    }

}
