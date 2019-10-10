package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Batch;
import com.zuoshao.tegeneral.service.BatchService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
