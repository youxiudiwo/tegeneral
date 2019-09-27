package com.zuoshao.tegeneral.mapper;

import com.zuoshao.tegeneral.bean.Index;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/9/24 - 11:56
 */
public interface IndexMapper{
    List<Index> selectindex();
    Integer insertindex(@Param("name")String name, @Param("weight")String weight, @Param("pid")Integer pid, @Param("sort")Integer sort);
    int deleteindex(Integer id);            //删除修改中
    Integer updateindex(@Param("name")String name, @Param("weight")String weight,@Param("id")Integer id);
}
