package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.T;
import com.zuoshao.tegeneral.service.IndexService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

//    @RequestMapping("indexTest")
//    public String indextest(){
//        return "indexTest";
//    }
    @RequestMapping("/selectIndex")
    @ResponseBody
    public T selectIndex(){                                   //读取树形结构
        List<Map<String,Object>> selectindex = indexService.selectIndex(0);
        T t = new T();
        t.setStatus(1);
        t.setMsg("数据测试");
        t.setData(selectindex);

        return t;
    }

    @RequestMapping("/insertIndex")
    @ResponseBody
    public Map insertindex(@Param("name")String name, @Param("weight")String weight, @Param("pid")Integer pid, @Param("sort")Integer sort){      //增加
        Map result = new HashMap();
        Integer insert = indexService.insertindex(name,weight,pid,sort);
        result.put("insertindex",insert);
        return result;
    }

    @RequestMapping("/deleteIndex")
    @ResponseBody
    public int deleteindex(Integer id){              //删除节点和页
        int delete = indexService.deleteindex(id);
        return delete;
    }

    @RequestMapping("/updateIndex")
    @ResponseBody
    public Integer  updateindex(@Param("name")String name, @Param("weight")String weight,@Param("id")Integer id){      //修改数据
        Integer update = indexService.updateindex(name,weight,id);
        return update;
    }
}
