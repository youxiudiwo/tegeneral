package com.zuoshao.tegeneral.mapper;

import com.zuoshao.tegeneral.bean.Menu;
import com.zuoshao.tegeneral.bean.Relationship;
import com.zuoshao.tegeneral.bean.Role;
import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.bean.beanexa.RelationShipmapping;
import com.zuoshao.tegeneral.bean.beanexa.RoleMenu;
import com.zuoshao.tegeneral.bean.beanexa.StudentClass;
import com.zuoshao.tegeneral.bean.beanexa.UserCple;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/9/11 - 9:16
 */
public interface Userrolemapper {
    public List<Menu> selectuserrole(User user);

    public List<UserCple> selectuserall();

    public UserCple selectuserforid(User user);

    public List<UserCple> selectuserforexa(User user);
    //查询所有的角色权限信息
    public List<RoleMenu> selectuserrolemeun();
    //查询所有的授课信息
    public List<RelationShipmapping> selectrealationship();
    //匹配查询一老师的授课信息
    public List<RelationShipmapping> selectrealationshipasexa(User user);
    //查询所有的班级学生信息
    public List<StudentClass> selectstudentclass();
    //匹配查询学生班级信息
    public List<StudentClass> selctclassstudentasexa(User user);
    //根据角色名字获取对应的菜单
    List<Menu> selectmenuforrole(Role role);
    //根据班级id获取所有的学生
    List<UserCple> selectstudentclassforid(Role role);
}
