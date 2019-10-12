package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.Score;
import com.zuoshao.tegeneral.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreService {
    List<Score> selectScore(@Param("userid") Integer userid, @Param("batch") Integer batch);
    List<Score> selectScore1(@Param("userid2") Integer userid2,@Param("batch") Integer batch);
    List<Score> selectallScore(Score score);
}
