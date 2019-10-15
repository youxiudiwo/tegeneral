package com.zuoshao.tegeneral.mapper;

import com.zuoshao.tegeneral.bean.*;
import com.zuoshao.tegeneral.bean.beanexa.*;

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
    //根据传入的名称查询相关试卷（传入对应批次和试卷名称得到当前批次的该试卷）
    Questionnaire selectquestionexa(Questionnaire questionnaire);
    //返回所有的试卷（批次）
    List<QustionBatch> selectquestionall();
    //返回试卷最新插入记录
    Questionnaire selectnewupdate();
    //插入试卷返回id
    Questionnaire insertquestion(Questionnaire questionnaire);

    //返回评教统计的人
    List<Pjtjbean> getpjtj();

    //模糊评教统计

    List<Pjtjbean> getpjtexa(User user);

    //分类查询试卷分数
    List<QuestionType> getquestiontypetj(Option option);
}
