package com.zuoshao.tegeneral.service;

import com.zuoshao.tegeneral.bean.Role;

import java.util.List;

public interface RoleService {
    Integer saveRole(Role role);

    Integer deleteRole(Role id);

    Integer updateRole(Role id);

    List<Role> getRole();
}
