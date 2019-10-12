package com.zuoshao.tegeneral.service.serviceimpl;

import com.zuoshao.tegeneral.bean.beanexa.FractionSum;
import com.zuoshao.tegeneral.bean.beanexa.GeneratePaper;
import com.zuoshao.tegeneral.bean.beanexa.PreviewPage;
import com.zuoshao.tegeneral.mapper.GeneralMapper;
import com.zuoshao.tegeneral.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: luquanlin
 * @Date: 2019/10/10 10:46
 * @VERSION: 1.0
 **/
@Service
public class GeneralServiceImpl implements GeneralService {
    @Autowired
    private GeneralMapper generalMapper;

    @Override
    public List<FractionSum> addFractions(int ixid, int osid) {
        return generalMapper.addFractions(ixid,osid);
    }

    @Override
    public Boolean insertGeneral(int userid, int userid2, int quid, int opid, int inid, int batch,String fraction) {
        int userResult = generalMapper.insertGeneral(userid, userid2, quid, opid, inid, batch,fraction);
        if(userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Map<String, Object>> selectOnlineEvaluation(int qid) {
        List<GeneratePaper> list = generalMapper.selectOnlineEvaluation(qid);
        List<GeneratePaper> listTwo = generalMapper.selectOnlineEvaluationOptions(qid);

        Map<Integer, List<GeneratePaper>> map = list.stream().collect(Collectors.groupingBy(GeneratePaper::getQid));
        List<Map<String, Object>> ret = new LinkedList<Map<String, Object>>();

        Map<Integer, List<GeneratePaper>> mapTwo = listTwo.stream().collect(Collectors.groupingBy(GeneratePaper::getIid));


        map.forEach( (k,v)->{
            Map<String, Object> tmap = new LinkedHashMap<>();
            tmap.put("id", k);
            List<Map<String, Object>> optionList = new LinkedList<>();
            v.stream().forEach(item->{
                Map<String, Object> omap = new LinkedHashMap<>();
                tmap.put("title", item.getQtn_name());
                tmap.put("batch",item.getB_name());
            });

            mapTwo.forEach((kTwo,vTwo) ->{
                Map<String, Object> tmapTwo = new LinkedHashMap<>();
                tmapTwo.put("id",kTwo);
                List<Map<String, Object>> optionListTwo = new LinkedList<>();
                vTwo.stream().forEach(itemTwo->{
                    Map<String, Object> omapTwo = new LinkedHashMap<>();
                    tmapTwo.put("title",itemTwo.getIx_name());
                    omapTwo.put("id",itemTwo.getOid());
                    omapTwo.put("title",itemTwo.getO_name());
                    optionListTwo.add(omapTwo);
                });
                tmapTwo.put("option",optionListTwo);
                optionList.add(tmapTwo);
            });
            tmap.put("problem", optionList);
            ret.add(tmap);
        });

        return ret;
    }

    @Override
    public List<Map<String, Object>> selectPage(int id) {
        List<PreviewPage> list = generalMapper.selectPage(id);
        Map<Integer, List<PreviewPage>> map = list.stream().collect(Collectors.groupingBy(PreviewPage::getIid));
        List<Map<String, Object>> ret = new LinkedList<Map<String, Object>>();
        map.forEach( (k,v)->{
            Map<String, Object> tmap = new LinkedHashMap<>();
            tmap.put("id", k);
            List<Map<String, Object>> optionList = new LinkedList<>();
            v.stream().forEach(item->{
                Map<String, Object> omap = new LinkedHashMap<>();
                tmap.put("title", item.getIx_name());

                omap.put("id", item.getOid());
                omap.put("title", item.getO_name());
                optionList.add(omap);
            });
            tmap.put("option", optionList);

            ret.add(tmap);
        });

        return ret;
    }

    @Override
    public List<FractionSum> addUserPageGeneral(int userid, int userid2, int quid, int batch) {
        return generalMapper.addUserPageGeneral(userid, userid2, quid, batch);
    }

    @Override
    public Boolean insertScorePageGeneral(int userid, int userid2, int batch, String scores, int question) {
        int userResult = generalMapper.insertScorePageGeneral(userid, userid2, batch, scores, question);
        if(userResult > 0){
            return true;
        }
        return false;
    }
}
