package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Menu;
import com.zuoshao.tegeneral.bean.Role;
import com.zuoshao.tegeneral.bean.beanexa.RoleMenu;
import com.zuoshao.tegeneral.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(description = "增加角色测试")
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

    @RequestMapping(value = "/getmenuall")
    @ResponseBody
    public  Map<String,Object> getmenuall(){
        List<Menu> menus = roleService.getmenuall();
        Map<String,Object> menuss = new HashMap<>();
        menuss.put("code",1);
        menuss.put("getmenuall",menus);
        return menuss;
    }

    @RequestMapping(value = "/getmenuforrole")
    @ResponseBody
    public  Map<String,Object> getmenuforrole(@Param("exa")String exa){
        Role role = new Role();
        role.setName(exa);
        List<Menu> menus = roleService.getmenuforrole(role);
        Map<String,Object> menuss = new HashMap<>();
        menuss.put("code",1);
        menuss.put("getmenuforrole",menus);
        return menuss;
    }


    @RequestMapping("/addrole")
    @ResponseBody
    @ApiOperation(value = "增加一个角色",httpMethod = "POST")
    public Map insertRole(@RequestParam String rolename,@RequestParam Integer[] menu){
        Map result = new HashMap();
        Role selects = roleService.selectRole(rolename);
        if(selects == null){
            Integer integer = roleService.insertRole(rolename);
            for(int i = 0;i<menu.length;i++){
                Integer menus = roleService.insertRo_Me(rolename,menu[i]);
            }
            result.put("selects",1);
        }else {
            result.put("selects1",0);
        }
        return result;
    }

    @RequestMapping("/addmenu")
    @ResponseBody
    @ApiOperation(value = "增加一个功能",httpMethod = "POST")
    public Integer insertMenu(@RequestParam String name,@RequestParam String img,@RequestParam String path){
        Integer integer = roleService.insertMenu(name,img,path);
        return integer;
    }

}
