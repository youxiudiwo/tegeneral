package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.InOp;
import com.zuoshao.tegeneral.bean.Index;
import com.zuoshao.tegeneral.bean.Option;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IndexService {
    List<Map<String,Object>> selectIndex(int pid);
    Integer insertindex(@Param("name")String name, @Param("weight")String weight, @Param("pid")Integer pid, @Param("sort")Integer sort);
    int deleteindex(Integer id);
    Integer updateindex1(@Param("name")String name,@Param("weight")String weight,@Param("id")Integer id);
//    Integer updateindex2(@Param("weight")String weight,@Param("id")Integer id);
    List<Index> selectindex1(Integer id);
    List<Option> selectoption(Integer id);
    Integer insertoption(@Param("name")String name, @Param("fraction")Integer fraction);
    Integer deleteoption();
    List<InOp> selectIn_Op(Integer id);

    Integer selectId(Integer pid);
    Integer selectSort(Integer pid);
    Integer insertIndexF(@Param("name")String name, @Param("pid")Integer pid, @Param("sort")Integer sort);
}
