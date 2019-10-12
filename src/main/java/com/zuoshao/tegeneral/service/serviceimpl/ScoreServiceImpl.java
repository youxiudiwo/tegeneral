package com.zuoshao.tegeneral.service.serviceimpl;

import com.zuoshao.tegeneral.bean.Score;
import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.bean.beanexa.Pjtjbean;
import com.zuoshao.tegeneral.mapper.ScoreMapper;
import com.zuoshao.tegeneral.mapper.Userrolemapper;
import com.zuoshao.tegeneral.service.ScoreService;
import com.zuoshao.tegeneral.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreMapper scoreMapper;
    @Autowired
    Userrolemapper userrolemapper;

    @Override
    public List<Score> selectScore(@Param("userid") Integer userid, @Param("batch") Integer batch){
        return scoreMapper.selectScore(userid,batch);
    }

    @Override
    public   List<Score> selectScore1(@Param("userid2") Integer userid2,@Param("batch") Integer batch){
        return scoreMapper.selectScore1(userid2, batch);
    }

    @Override
    public List<Score> selectallScore(Score score) {
        List<Score> scores = scoreMapper.select(score);
        return scores;
    }

    @Override
    public List<Pjtjbean> getpjtj() {
        List<Pjtjbean> getpjtj = userrolemapper.getpjtj();
        return getpjtj;
    }

    @Override
    public List<Pjtjbean> getpjtjexa(User user) {
        List<Pjtjbean> getpjtexa = userrolemapper.getpjtexa(user);
        return getpjtexa;
    }

}
