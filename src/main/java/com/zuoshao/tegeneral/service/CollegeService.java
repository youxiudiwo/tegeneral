package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.College;

import java.util.List;

public interface CollegeService {
    Integer addCollege(College college);

    Integer deleteCollege(College college);

    Integer updateCollege(College college);

    College getCollege(College college);

    List<College> getCollege();
    String selectCollegeName(Integer id);
}
