package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.Batch;

import java.util.List;

public interface BatchService {
    Integer addBatch(Batch batch);

    Integer deleteBatch(Batch batch);

    Integer updateBatch(Batch batch);

    List<Batch> getBatch();
    //查看当前批次是否开启
    Batch getbatchstate(Batch batch);

    Integer updateBatchF(Integer id);
    Integer updateBatchT(Integer id);
    List<Batch> selectBatch();

}
