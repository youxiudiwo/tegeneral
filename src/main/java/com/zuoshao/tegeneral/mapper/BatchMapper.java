package com.zuoshao.tegeneral.mapper;

import com.zuoshao.tegeneral.bean.Batch;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface BatchMapper extends Mapper<Batch> {
    Integer updateBatchF(Integer id);
    Integer updateBatchT(Integer id);
    List<Batch> selectBatch();
}
