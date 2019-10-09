package com.zuoshao.tegeneral.service.serviceimpl;

import com.zuoshao.tegeneral.bean.Batch;
import com.zuoshao.tegeneral.mapper.BatchMapper;
import com.zuoshao.tegeneral.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    private BatchMapper batchMapper;

    @Override
    public Integer addBatch(Batch batch) {
        return batchMapper.insert(batch);
    }

    @Override
    public Integer deleteBatch(Batch batch) {
        return batchMapper.delete(batch);
    }

    @Override
    public Integer updateBatch(Batch batch) {
        return batchMapper.updateByPrimaryKey(batch);
    }

    @Override
    public List<Batch> getBatch() {
        return batchMapper.selectAll();
    }

    @Override
    public Batch getbatchstate(Batch batch) {
        Batch batch1 = batchMapper.selectOne(batch);
        return batch1;
    }
}
