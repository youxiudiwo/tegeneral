package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Batch;
import com.zuoshao.tegeneral.service.BatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Api(description = "批次管理接口")
@Controller
public class BatchController {
    @Autowired
    private BatchService batchService;
    @RequestMapping("/addBatch")
    @ResponseBody
    public Integer addBatch(Batch batch){
        return batchService.addBatch(batch);
    }
    @RequestMapping("/deleteBatch")
    @ResponseBody
    public Integer deleteBatch(Batch batch){
        return batchService.deleteBatch(batch);
    }
    @RequestMapping("/updateBatch")
    @ResponseBody
    public Integer updateBatch(Batch batch){
        return batchService.updateBatch(batch);
    }
    @RequestMapping("/getBatch")
    @ResponseBody
    public List<Batch> getBatch(){
        return batchService.getBatch();
    }


    @RequestMapping("/updateBatchF")                   //关闭批次
    @ResponseBody
    @ApiOperation(value = "关闭批次",httpMethod = "POST")
    public Integer updateBatchF(){
        List<Batch> a = batchService.selectBatch();
        List<Integer> list = new ArrayList<>();

        for(int i = 0;i<a.size();i++){
            list.add(a.get(i).getId());
        }
        for (int i = 0;i<list.size();i++){
            Integer b =  batchService.updateBatchF(list.get(i));
        }
        return 1;
    }

    @RequestMapping("/updateBatchT")                 //开启批次
    @ResponseBody
    @ApiOperation(value = "开启批次",httpMethod = "POST")
    public Integer updateBatchT(@RequestParam Integer id){
        List<Batch> a = batchService.selectBatch();
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<a.size();i++){
            list.add(a.get(i).getId());
        }
        for (int i = 0;i<list.size();i++){
            Integer b =  batchService.updateBatchF(list.get(i));
        }
        Integer c = batchService.updateBatchT(id);
        return c;
    }
}
