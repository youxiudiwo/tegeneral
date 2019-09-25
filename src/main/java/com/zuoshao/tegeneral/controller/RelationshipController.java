package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Class;
import com.zuoshao.tegeneral.bean.Relationship;
import com.zuoshao.tegeneral.bean.User;
import com.zuoshao.tegeneral.bean.beanexa.RelationShipmapping;
import com.zuoshao.tegeneral.bean.beanexa.StudentClass;
import com.zuoshao.tegeneral.service.RelationshipService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zuoshao
 * @date 2019/9/23 - 9:40
 */
@RestController
public class RelationshipController {

    @Autowired
    RelationshipService relationshipService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/getrelationship")
    @ResponseBody
    public Map<String,Object> getrelationship(){
        List<RelationShipmapping> getrelationship = relationshipService.getrelationship();
        Map<String, Object> menuss = new HashMap<String, Object>();
        menuss.put("code",1);
        menuss.put("relationship",getrelationship);
        return menuss;
    }

    @RequestMapping("/getrelationshipasexa")
    @ResponseBody
    public Map<String,Object> getrelationshipasexa(@Param("exa")String exa){
        User user = new User();
        user.setName(exa);
        List<RelationShipmapping> getrelationshipasexa = relationshipService.getrelationshipasexa(user);
        Map<String, Object> menuss = new HashMap<>();

        menuss.put("code",1);
        menuss.put("relationshipexa",getrelationshipasexa);
        return menuss;
    }

    @RequestMapping("/getstudentclass")
    @ResponseBody
    public Map<String,Object> getstudentclass(){
        List<StudentClass> getstudentclass = relationshipService.getstudentclass();
        Map<String, Object> menuss = new HashMap<>();
        menuss.put("code",1);
        menuss.put("getstudentclass",getstudentclass);
        return menuss;
    }

    @RequestMapping("/getclassall")
    @ResponseBody
    public Map<String,Object> getallclass(){
        List<Class> getclassall = relationshipService.getclassall();
        Map<String, Object> menuss = new HashMap<>();
        menuss.put("code",1);
        menuss.put("getclassall",getclassall);
        return menuss;
    }

    @RequestMapping("/getstudentclassasexa")
    @ResponseBody
    public Map<String,Object> getstudentclassasexa(@Param("exa")String exa){
        User user = new User();
        user.setName(exa);
        List<StudentClass> list = relationshipService.getstudentclassasexa(user);
        Map<String, Object> menuss = new HashMap<>();
        menuss.put("code",1);
        menuss.put("getstudentclassasexa",list);
        return menuss;
    }

}
