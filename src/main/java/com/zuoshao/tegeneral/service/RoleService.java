package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.Menu;
import com.zuoshao.tegeneral.bean.Role;
import com.zuoshao.tegeneral.bean.beanexa.RoleMenu;
import com.zuoshao.tegeneral.bean.beanexa.UserCple;
import com.zuoshao.tegeneral.mapper.Userrolemapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RoleService {

    Integer saveRole(Role role);

    Integer deleteRole(Role id);

    Integer updateRole(Role id);

    List<Role> getRole();

    List<RoleMenu> getrolemenu();

    List<Menu> getmenuall();

    List<Menu> getmenuforrole(Role role );

    Integer insertRole(String rolename);               //以下新增
    Integer insertRo_Me(@Param("rolename") String rolename, @Param("menuId") Integer menuId);
    Role selectRole(String rolename);

    Integer insertMenu(@Param("name") String name, @Param("img") String img,@Param("path") String path);
}
