package com.zuoshao.tegeneral.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zuoshao.tegeneral.bean.*;
import com.zuoshao.tegeneral.bean.beanexa.UserCple;
import com.zuoshao.tegeneral.mapper.Usermapper;
import com.zuoshao.tegeneral.service.CollegeService;
import com.zuoshao.tegeneral.service.UserService;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@Api(description = "用户管理接口")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CollegeService collegeService;


    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String,Object> userlogin(@RequestParam("password")String password, @RequestParam("username")String username, HttpSession session) throws Exception{

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Map<String,Object> menuss=new HashMap<>();

        User userlogin = userService.userlogin(user);

        if (userlogin != null)
        {
            List<List<Menu>> lists = new ArrayList<>();
            List<Menu> menus = userService.userMenu(userlogin);
            menuss.put("menu",menus);
            menuss.put("code",1);

        }else {
            menuss.put("mags","用户名或者密码不正确");
            menuss.put("code",0);

        }
        return menuss;
    }

    @RequestMapping(value = "/getmenu")
    @ResponseBody
    public Map<String,Object> userlogin(@RequestParam("username")String username, HttpSession session){
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


    @GetMapping("/getuserall")
    @ResponseBody
    public PageInfo<UserCple> getAllPerson(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam("pageSize")Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserCple> list = userService.selectuserall();
        PageInfo<UserCple> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }




    @RequestMapping("/getuserforid")
    @ResponseBody
    public Map<String, Object> getuserfotid(@RequestParam("id")Integer id){
        User user = new User();
        user.setId(id);
        UserCple selectuserforid = userService.selectuserforid(user);
        Map<String,Object> menuss=new HashMap<>();
        menuss.put("code",1);
        menuss.put("userforid",selectuserforid);
        return menuss;
    }

    @RequestMapping("/getuserforuserexa")
    @ResponseBody
    public Map<String, Object> getuserforuserexa(@RequestParam("exa")String exa){
        User user = new User();
        user.setName(exa);
        List<UserCple> selectuserforexa = userService.selectuserforexa(user);
        Map<String,Object> menuss=new HashMap<>();
        menuss.put("code",1);
        menuss.put("userforexa",selectuserforexa);
        return menuss;
    }



    @RequestMapping("/getstudent")
    @ResponseBody
    public  PageInfo<UserCple> getstudent(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam("pageSize")Integer pageSize,@RequestParam("solter")Integer solter){
        if (solter==0) {
            User user = new User();
            user.setName("学生");
            PageHelper.startPage(pageNum, pageSize);
            List<UserCple> selectuserforexa = userService.selectuserforexa(user);
            PageInfo<UserCple> pageInfo = new PageInfo<>(selectuserforexa);
            return pageInfo;
        }else {
            Role role = new Role();
            role.setId(solter);
            PageHelper.startPage(pageNum, pageSize);
            List<UserCple> getstudentforclassid = userService.getstudentforclassid(role);
            PageInfo<UserCple> pageInfo = new PageInfo<>(getstudentforclassid);
            return pageInfo;
        }
    }



    @RequestMapping("/edituser")
    @ResponseBody
    public Map<String,Object> updateuser(@RequestBody Map map) throws Exception{

//        HashMap<String, Object> map = new HashMap<>();
//        map.put("userid","1");
//        map.put("username","zuolei");
//        map.put("name","左雷");
//        map.put("college","软件学院");
//        map.put("reset",true);
//        List<Object> listtest = new ArrayList<>();
//        listtest.add("学生");
//        listtest.add("老师");
//        map.put("role",listtest);

        String username =(String) map.get("username");
        String name =(String) map.get("name");
        String colleges = (String) map.get("college");
        Boolean reset= (Boolean) map.get("reset");

        String userid1 = (String)map.get("userid");
        Integer userid = Integer.parseInt(userid1);

        User user = new User();
        user.setUsername(username);
        User userlogin = userService.userlogin(user);

        College college = new College();
        college.setName(colleges);
        College college1 = collegeService.getCollege(college);

        if (reset==true){
            User user1 = new User();
            user1.setCollid(college1.getId());
            user1.setUsername(username);
            user1.setName(name);
            user1.setPassword("111111");
            user1.setId(userid);
            userService.updateuser(user1);

        }else {
            User user2 = new User();
            user2.setCollid(college1.getId());
            user2.setUsername(username);
            user2.setName(name);
            user2.setId(userid);
            userService.updateuser(user2);
        }

        //添加该用户的角色关联
        try {
            List<String> listss= (ArrayList<String>) map.get("role");
            //删除该用户的角色关联
            UsRo usRo = new UsRo();
            usRo.setUid(userlogin.getId());
            userService.deleteuserrole(usRo);

            UsRo usRo1 = new UsRo();
            usRo1.setUid(userlogin.getId());
            for (String role:listss) {
                int anInt = Integer.parseInt(role);
                usRo1.setRid(anInt);
                Integer integer = userService.adduserrole(usRo1);
            }
            Map<String,Object> menuss=new HashMap<>();
            menuss.put("code",1);
            return menuss;
        }catch (Exception e){
            Map<String,Object> menuss=new HashMap<>();
            menuss.put("code",2);
            return menuss;
        }

    }


    @RequestMapping("/adduser")
    @ResponseBody
    public Map<String,Object> adduser(@RequestBody Map map) throws Exception{

        String username =(String) map.get("username");
        String name =(String) map.get("name");
        String colleges = (String) map.get("college");
        Integer collegei =Integer.parseInt(colleges);

        ArrayList<Integer> listss= (ArrayList<Integer>) map.get("role");
        System.out.println(listss);
        List<Integer> rolei = new ArrayList<>();
//        Integer[] rolei = new Integer[20];
        for (Integer role:listss) {
            rolei.add(role);
        }

        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword("111111");
        user.setCollid(collegei);

        User user2 = new User();
        user2.setUsername(username);
        List<User> selectuserzhuce = userService.selectuserzhuce(user2);

        Map<String,Object> menuss=new HashMap<>();

        if (selectuserzhuce.size()!=0){
            menuss.put("code",0);
            menuss.put("msg","添加失败用户名重复");
            return menuss;
        }else {
            Integer adduser = userService.adduser(user);
            if (adduser==1){

                User user1 = new User();
                user1.setUsername(username);
                User userlogin = userService.userlogin(user1);
                UsRo usro = new UsRo();
                usro.setUid(userlogin.getId());

                List<Object> list = new ArrayList<>();
                for (Integer roleid:rolei) {
                    usro.setRid(roleid);
                    Integer integer = userService.adduserrole(usro);
                    list.add(integer);
                }
                menuss.put("code",1);
                return menuss;
            }else {
                menuss.put("code",0);
                return menuss;
            }
        }

    }

}
