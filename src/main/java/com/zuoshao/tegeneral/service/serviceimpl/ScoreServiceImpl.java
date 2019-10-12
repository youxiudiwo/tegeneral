package com.zuoshao.tegeneral.service.serviceimpl;

import com.zuoshao.tegeneral.bean.Score;
import com.zuoshao.tegeneral.mapper.ScoreMapper;
import com.zuoshao.tegeneral.service.ScoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public List<Score> selectScore(@Param("userid") Integer userid, @Param("batch") Integer batch){
        return scoreMapper.selectScore(userid,batch);
    }

    @Override
    public   List<Score> selectScore1(@Param("userid2") Integer userid2,@Param("batch") Integer batch){
        return scoreMapper.selectScore1(userid2, batch);
    }
}
