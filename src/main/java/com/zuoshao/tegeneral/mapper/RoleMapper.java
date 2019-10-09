package com.zuoshao.tegeneral.mapper;

import com.zuoshao.tegeneral.bean.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<Role> {
    Integer insertRole(String rolename);
    Integer insertRo_Me(@Param("rolename") String rolename, @Param("menuId") Integer menuId);
    Role selectRole(String rolename);
}
