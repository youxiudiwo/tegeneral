package com.zuoshao.tegeneral.mapper;

import com.zuoshao.tegeneral.bean.Index;
import com.zuoshao.tegeneral.bean.Option;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/9/24 - 11:56
 */
public interface IndexMapper{
    List<Index> selectindex();
    Integer insertindex(@Param("name")String name, @Param("weight")String weight, @Param("pid")Integer pid, @Param("sort")Integer sort);
    int deleteindex(Integer id);            //删除修改中
    Integer updateindex1(@Param("name")String name,@Param("id")Integer id);
    Integer updateindex2(@Param("weight")String weight,@Param("id")Integer id);
    List<Index> selectindex1(Integer id);
    List<Option> selectoption();
    Integer insertoption(@Param("name")String name, @Param("fraction")Integer fraction);
    Integer deleteoption();

    Integer selectId(Integer pid);
    Integer selectSort(Integer pid);
    Integer insertIndexF(@Param("name")String name, @Param("pid")Integer pid, @Param("sort")Integer sort);
}
