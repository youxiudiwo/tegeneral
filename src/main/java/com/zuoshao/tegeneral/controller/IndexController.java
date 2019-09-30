package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Index;
import com.zuoshao.tegeneral.bean.Option;
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
    public int deleteindex(Integer id){              //删除节点和叶，目前只能删除选中的那一个，修改中。。。。
        int delete = indexService.deleteindex(id);
        return delete;
    }

    @RequestMapping("/updateIndex1")
    @ResponseBody
    public Integer  updateindex1(@Param("name")String name,@Param("id")Integer id){      //修改指标名称
        Integer update = indexService.updateindex1(name,id);
        return update;
    }
    @RequestMapping("/updateIndex2")
    @ResponseBody
    public Integer  updateindex2(@Param("weight")String weight,@Param("id")Integer id){      //修改指标权重
        Integer update = indexService.updateindex2(weight,id);
        return update;
    }

    @RequestMapping("/selectIndexOption")
    @ResponseBody
    public Map  selectIndexOption(Integer id){                            //点击指标名称，显示查询名称和权重以及选项
        Map result = new HashMap();
        List<Index> selectindex1 = indexService.selectindex1(id);
        List<Option> selectoption = indexService.selectoption();
        result.put("selectindex1",selectindex1);
        result.put("selectoption",selectoption);
        return result;
    }

    @RequestMapping( "/insertOption")
    @ResponseBody
    public Integer updateoption(String name1,Integer fraction1,String name2,Integer fraction2,String name3,Integer fraction3,String name4,Integer fraction4){                            //修改选项
        Integer s = indexService.deleteoption();
        Integer a = indexService.insertoption("name1",0);
        Integer b = indexService.insertoption("name2",0);
        Integer c = indexService.insertoption("name3",0);
        Integer d = indexService.insertoption("name4",0);
        return s + a + b + c + d;
    }

}
