package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Menu;
import com.zuoshao.tegeneral.bean.Role;
import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/9/9 - 12:09
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public List<Menu> userlogin(User user, HttpSession session){
        user.setUsername("zuolei");
        user.setPassword("123456");

        User userlogin = userService.userlogin(user);

        if (userlogin != null)
        {
            List<Menu> menus = userService.userMenu(userlogin);
            session.setAttribute("menus",menus);
            session.setAttribute("user",userlogin);
            return menus;

        }else {
            session.setAttribute("mags","用户名或者密码不正确");
            return null;
        }

    }


}
