package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.Role;
import com.zuoshao.tegeneral.bean.beanexa.RoleMenu;
import com.zuoshao.tegeneral.bean.beanexa.UserCple;
import com.zuoshao.tegeneral.mapper.Userrolemapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RoleService {

    Integer saveRole(Role role);

    Integer deleteRole(Role id);

    Integer updateRole(Role id);

    List<Role> getRole();

    List<RoleMenu> getrolemenu();
}
