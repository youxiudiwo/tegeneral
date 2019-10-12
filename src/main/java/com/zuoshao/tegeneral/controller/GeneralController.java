package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.bean.beanexa.FractionSum;
import com.zuoshao.tegeneral.bean.beanexa.ScoreAdd;
import com.zuoshao.tegeneral.service.GeneralService;
import com.zuoshao.tegeneral.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Author: luquanlin
 * @Date: 2019/10/10 10:55
 * @VERSION: 1.0
 **/
@Api(description = "试卷提交信息和分数管理接口",value = "")
@Controller
public class GeneralController {
    @Autowired
    private GeneralService generalService;

    @Autowired
    private UserService userService;

    @ApiOperation(value="评教完成后储存信息，评价总表和分数汇总表", notes="test: 1有正确返回0发生异常错误",httpMethod = "POST")
    @ApiImplicitParam(name = "scoreAdd" ,value = "JSONObject",required = true)
    @RequestMapping("/insertGeneral")
    @ResponseBody
    public Map insertGeneral(@RequestBody ScoreAdd scoreAdd){
        Map result =new HashMap();

        //得到评分人ID
        User user2 = new User();
        user2.setUsername(scoreAdd.getName());
        User userlogin = userService.userlogin(user2);
        int userid = userlogin.getId();
        //被评分人ID
        int userid2 = 0;
        //试卷ID
        int quid = 0;
        //批次ID
        int batch = 0;
        //指标ID
        int ixid = 0;
        //选项ID
        int osid = 0;

        //每道题的分数
        float sum = 0;

        //试卷总分数
        float add = 0;
        for (int i=0;i<scoreAdd.getProblem().size();i++){
            //被评分人ID
            userid2 = scoreAdd.getTid();
            //试卷ID
            quid = scoreAdd.getId();
            //批次ID
            batch = scoreAdd.getBid();
            //指标ID
            ixid = scoreAdd.getProblem().get(i).getId();
            //选项ID
            osid = scoreAdd.getProblem().get(i).getClick();

            //查询此题目的此选项分数
            List<FractionSum> fractions = generalService.addFractions(ixid,osid);
            //计算此题的分数
            sum = fractions.get(0).getFraction();
            String fraction = String.valueOf(sum);
            if (generalService.insertGeneral(userid,userid2,quid,ixid,osid,batch,fraction)){
                result.put("test",1);
            }else{
                result.put("test",0);
            }
        }
        //计算整张试卷的分数
        List<FractionSum> scoresAdd = generalService.addUserPageGeneral(userid,userid2,quid,batch);
        add = scoresAdd.get(0).getFraction();
        String scores = String.valueOf(add);
        if (generalService.insertScorePageGeneral(userid,userid2,batch,scores,quid)){
            result.put("test",1);
        }else{
            result.put("test",0);
        }
        return result;
    }

    //    生成试卷
    @ApiOperation(value="生成试卷", notes="直接返回数据")
    @ApiImplicitParam(paramType="query", name = "qid", value = "试卷ID", required = true, dataType = "int")
    @ResponseBody
    @RequestMapping("/selectOnlineEvaluation")
    public Map selectOnlineEvaluation(int qid){
        Map result=new HashMap();
        List<Map<String, Object>> online = generalService.selectOnlineEvaluation(qid);
        result.put("subdata",online);
        return result;
    }

    //添加试卷的时候预览
    @ApiOperation(value="添加试卷预览", notes="直接返回数据",httpMethod = "POST")
    @ApiImplicitParam(paramType="query", name = "index", value = "指标ID", required = true, dataType = "String")
    @ResponseBody
    @RequestMapping("/previewPage")
    public Map  selectPage(String index){
        Map result=new HashMap();
        List<Map<String, Object>> indexList = new LinkedList<>();
        List<Object> optionList = new LinkedList<>();
        String indexId[]=index.split(",");
        for (int i=0;i<indexId.length;i++) {
            int id = Integer.parseInt(indexId[i]);
            Map<String, Object> omap = new LinkedHashMap<>();
            List<Map<String, Object>> indexOptions = generalService.selectPage(id);
            optionList.add(indexOptions);
        }
        result.put("problem",optionList);
        return result;
    }
}
