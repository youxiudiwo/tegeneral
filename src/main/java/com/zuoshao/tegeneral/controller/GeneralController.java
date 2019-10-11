package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.bean.beanexa.FractionSum;
import com.zuoshao.tegeneral.service.GeneralService;
import com.zuoshao.tegeneral.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ApiOperation(value="评教完成后储存信息，评价总表", notes="test: 1有正确返回0发生异常错误")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "username", value = "评分人姓名", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "userid2", value = "被评分人ID", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "quid", value = "问卷编号", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "opids", value = "选项编号数组", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "inids", value = "题目编号数组", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "batch", value = "批次ID", required = true, dataType = "int")
   })
    @RequestMapping("/insertGeneral")
    @ResponseBody
    public Map insertGeneral(String username, int userid2, int quid, String opids, String inids, int batch){

        User user2 = new User();
        user2.setUsername(username);
        User userlogin = userService.userlogin(user2);
        int userid = userlogin.getId();

        String a[]=opids.split(",");//选项的ID数组
        String t[]=inids.split(",");//题目的ID数组
        Map result =new HashMap();
        float sum = 0;//计算总分
        for (int i=0;i<a.length;i++){
            String options = a[i];//选项单独一个
            String targets_id = t[i];//题目单独一个

            //转换成int类型
            int ixid = Integer.parseInt(options);
            int osid = Integer.parseInt(targets_id);


            FractionSum fractionSum = new FractionSum();
            List<FractionSum> fractions = generalService.addFractions(ixid,osid);//查询此题目的此选项分数
            sum = fractions.get(0).getFraction();//计算整张试卷分数
            String fraction = String.valueOf(sum);
            if (generalService.insertGeneral(userid,userid2,quid,ixid,osid,batch,fraction)){
                result.put("test",1);
            }else{
                result.put("test",0);
            }
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
        result.put("subdata::",online);
        return result;
    }
}
