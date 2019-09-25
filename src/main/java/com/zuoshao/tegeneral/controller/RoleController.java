package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Role;
import com.zuoshao.tegeneral.bean.beanexa.RoleMenu;
import com.zuoshao.tegeneral.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("/addRole")
    @ResponseBody
    public Integer addrole(Role role, HttpSession session){
        role.setName("领导");
        Integer integer = roleService.saveRole(role);
        return integer;
    }
    @RequestMapping("/deleteRole")
    @ResponseBody
    public Integer deleteRole(Role id){
        return roleService.deleteRole(id);
    }
    @RequestMapping("/updateRole")
    @ResponseBody
    public Integer updateRole(Role id){
        return roleService.updateRole(id);
    }
    @RequestMapping("/getRole")
    @ResponseBody
    public List<Role> getRole(){
        return roleService.getRole();
    }

    @RequestMapping(value = "/test")
    public String test(){
        return "test";
    }

    @RequestMapping(value = "/getrolemenu")
    @ResponseBody
    public Map<String,Object> getrolemenu()
    {
        List<RoleMenu> getrolemenu = roleService.getrolemenu();
        Map<String,Object> menuss = new HashMap<>();
        menuss.put("code",1);
        menuss.put("rolemenu",getrolemenu);
        return menuss;
    }
}
