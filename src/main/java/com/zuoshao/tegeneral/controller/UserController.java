package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Menu;
import com.zuoshao.tegeneral.bean.Role;
import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String,Object> userlogin(User user, HttpSession session){
        user.setUsername("zuolei");
        user.setPassword("123456");

        User userlogin = userService.userlogin(user);

        if (userlogin != null)
        {
            List<List<Menu>> lists = new ArrayList<>();
            List<Menu> menus = userService.userMenu(userlogin);
            Map<String,Object> menuss=new HashMap<>();
            menuss.put("menu",menus);
            menuss.put("code",1);


            session.setAttribute("user",userlogin);
            return menuss;

        }else {
            session.setAttribute("mags","用户名或者密码不正确");
            return null;
        }

    }

    @RequestMapping(value = "/getmenu")
    @ResponseBody
    public Map<String,Object> userlogin(@Param("username")String username, HttpSession session){
        User user = new User();
        user.setUsername(username);
        User userlogin = userService.userlogin(user);
        Map<String,Object> menuss=new HashMap<>();

        if (user == null)
        {
            menuss.put("code",0);
            menuss.put("msg","没有查询结果");

        }else {
            List<List<Menu>> lists = new ArrayList<>();
            List<Menu> menus = userService.userMenu(userlogin);
            menuss.put("menu",menus);
            menuss.put("code",1);
            session.setAttribute("user",userlogin);

        }
        return menuss;
    }
}
