package com.zuoshao.tegeneral.mapper;

import com.zuoshao.tegeneral.bean.beanexa.FractionSum;
import com.zuoshao.tegeneral.bean.beanexa.GeneratePaper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/10 10:11
 * @VERSION: 1.0
 **/
@Repository
public interface GeneralMapper{
    List<FractionSum> addUserPageGeneral(@Param("userid")int userid,@Param("userid2")int userid2,@Param("quid")int quid,@Param("batch")int batch);
    List<GeneratePaper> selectOnlineEvaluation(@Param("qid")int qid);
    List<GeneratePaper> selectOnlineEvaluationOptions(@Param("qid")int qid);
    List<FractionSum> addFractions(@Param("ixid") int ixid, @Param("osid") int osid);
    int insertGeneral(@Param("userid")int userid,@Param("userid2")int userid2,@Param("quid")int quid,@Param("opid")int opid,@Param("inid")int inid,@Param("batch")int batch,@Param("fraction")String fraction);
    int insertScorePageGeneral(@Param("userid")int userid,@Param("userid2")int userid2,@Param("batch")int batch,@Param("scores")String scores,@Param("question")int question);
}
