package com.zuoshao.tegeneral.service.serviceimpl;

import com.zuoshao.tegeneral.bean.Menu;
import com.zuoshao.tegeneral.bean.Role;
import com.zuoshao.tegeneral.bean.UsRo;
import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.bean.beanexa.UserCple;
import com.zuoshao.tegeneral.mapper.Usermapper;
import com.zuoshao.tegeneral.mapper.Userrolemapper;
import com.zuoshao.tegeneral.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/9/11 - 8:48
 */
@Service
public class Userserviceimpl implements UserService {
    @Autowired
    Usermapper usermapper;
    @Autowired
    Userrolemapper userrolemapper;

    @Override
    public User userlogin(User user) {
        User user1 = usermapper.selectOne(user);
        return user1;
    }

    @Override
    public List<Menu> userMenu(User user) {
        List<Menu> menus = userrolemapper.selectuserrole(user);
        return menus;
    }

    @Override
    public List<UserCple> selectuserall() {
        List<UserCple> selectuserall = userrolemapper.selectuserall();
        return selectuserall;
    }

    @Override
    public UserCple selectuserforid(User user) {
        UserCple selectuserforid = userrolemapper.selectuserforid(user);
        return selectuserforid;
    }

    @Override
    public List<UserCple> selectuserforexa(User user) {
        List<UserCple> selectuserforexa = userrolemapper.selectuserforexa(user);
        return selectuserforexa;
    }


}
