package com.zuoshao.tegeneral.service.serviceimpl;

import com.zuoshao.tegeneral.bean.College;
import com.zuoshao.tegeneral.mapper.CollegeMapper;
import com.zuoshao.tegeneral.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;
    @Override
    public Integer addCollege(College college) {
        return collegeMapper.insert(college);
    }

    @Override
    public Integer deleteCollege(College college) {
        return collegeMapper.delete(college);
    }

    @Override
    public Integer updateCollege(College college) {
        return collegeMapper.updateByPrimaryKey(college);
    }

    @Override
    public College getCollege(College college) {
        College select = collegeMapper.selectOne(college);
        return select;
    }

    @Override
    public List<College> getCollege() {
        return collegeMapper.selectAll();
    }

}
