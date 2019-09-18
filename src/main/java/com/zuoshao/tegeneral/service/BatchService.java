package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.Batch;

import java.util.List;

public interface BatchService {
    Integer addBatch(Batch batch);

    Integer deleteBatch(Batch batch);

    Integer updateBatch(Batch batch);

    List<Batch> getBatch();

}
