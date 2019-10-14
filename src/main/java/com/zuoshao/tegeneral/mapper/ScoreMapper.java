package com.zuoshao.tegeneral.mapper;

import com.zuoshao.tegeneral.bean.Score;
import com.zuoshao.tegeneral.bean.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ScoreMapper extends Mapper<Score> {
    List<Score> selectScore(@Param("userid") Integer userid,@Param("batch") Integer batch);
    List<Score> selectScore1(@Param("userid2") Integer userid2,@Param("batch") Integer batch);

    List<Score> select();

    List<Score> selectScoreTeacher(Integer id);
    Integer selectUserId(String name);
    String selectBatchName(Integer id);
}
