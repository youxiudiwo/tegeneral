package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.InOp;
import com.zuoshao.tegeneral.bean.Index;
import com.zuoshao.tegeneral.bean.Option;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IndexService {
    List<Map<String,Object>> selectIndex(int pid);
    Integer insertindex(@Param("id")Integer id,@Param("name")String name, @Param("weight")String weight, @Param("pid")Integer pid, @Param("sort")Integer sort);
    int deleteindex(Integer id);
    Integer updateindex1(@Param("name")String name,@Param("weight")String weight,@Param("id")Integer id);
//    Integer updateindex2(@Param("weight")String weight,@Param("id")Integer id);
    List<Index> selectindex1(Integer id);
    List<Option> selectoption(Integer id);
    Integer insertoption(@Param("id")Integer id,@Param("name")String name, @Param("fraction")String fraction);
    Integer deleteoption();
    List<InOp> selectIn_Op(Integer id);
    Integer updateOption(@Param("name")String name,@Param("fraction")String fraction,@Param("id")Integer id);
    Integer selectIdOption(Integer id);
    Integer selectIdIndex(Integer id);
    Integer insertIn_Op(@Param("iid")Integer iid,@Param("oid")Integer oid);

    Integer selectId(Integer pid);
    Integer selectSort(Integer pid);
    Integer insertIndexF(@Param("name")String name, @Param("pid")Integer pid, @Param("sort")Integer sort);
    Integer selectindexziji(Index index);
    Integer selectIdMax();
    Integer deleteIn_OP(Integer id);
}
