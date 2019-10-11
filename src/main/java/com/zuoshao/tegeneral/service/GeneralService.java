package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.beanexa.FractionSum;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/10/10 10:21
 * @VERSION: 1.0
 **/
public interface GeneralService {
    //计算分数
    List<FractionSum> addFractions(@Param("ixid") int ixid, @Param("osid") int osid);
    //插入试卷信息
    Boolean insertGeneral(@Param("userid")int userid,@Param("userid2")int userid2,@Param("quid")int quid,@Param("opid")int opid,@Param("inid")int inid,@Param("batch")int batch,@Param("fraction")String fraction);
    //生成试卷
    List<Map<String, Object>> selectOnlineEvaluation(@Param("qid")int qid);
    List<Map<String, Object>> selectOnlineEvaluationOptions(@Param("qid")int qid);
    //计算总分
    List<HashMap> addUserPageGeneral(@Param("userid")int userid, @Param("userid2")int userid2, @Param("quid")int quid, @Param("batch")int batch);
}
