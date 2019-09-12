package com.zuoshao.tegeneral.mapper;

import com.zuoshao.tegeneral.bean.Menu;
import com.zuoshao.tegeneral.bean.Role;
import com.zuoshao.tegeneral.bean.User;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/9/11 - 9:16
 */
public interface Userrolemapper {
    public List<Menu> selectuserrole(User user);
}
