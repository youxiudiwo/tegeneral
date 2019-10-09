package com.zuoshao.tegeneral.mapper;

import com.zuoshao.tegeneral.bean.Menu;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zuoshao
 * @date 2019/9/25 - 10:09
 */
public interface MenuMapper extends Mapper<Menu> {
    Integer insertMenu(@Param("name") String name, @Param("img") String img,@Param("path") String path);
}
