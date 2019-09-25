package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.Index;

import java.util.List;
import java.util.Map;

/**
 * @author zuoshao
 * @date 2019/9/24 - 12:06
 */
public interface QuestionService {

    //查询所有指标
    List<Map<String, Object>> getindexalltrue(Integer id);
    //
}
