package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.Index;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IndexService {
    List<Map<String,Object>> selectIndex(int pid);
    Integer insertindex(@Param("name")String name, @Param("weight")String weight, @Param("pid")Integer pid, @Param("sort")Integer sort);
    int deleteindex(Integer id);
    Integer updateindex(@Param("name")String name, @Param("weight")String weight,@Param("id")Integer id);
}
