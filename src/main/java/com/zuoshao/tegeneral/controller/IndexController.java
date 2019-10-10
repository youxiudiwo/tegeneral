package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.Index;
import com.zuoshao.tegeneral.bean.Option;
import com.zuoshao.tegeneral.bean.T;
import com.zuoshao.tegeneral.service.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(description = "指标管理接口")
public class IndexController {

    @Autowired
    IndexService indexService;

//    @RequestMapping("indexTest")
//    public String indextest(){
//        return "indexTest";
//    }
    @RequestMapping("/selectIndex")
    @ResponseBody
    @ApiOperation(value = "查询树形指标结构",httpMethod = "POST")
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
    @ApiOperation(value = "增加指标",httpMethod = "POST")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name",value = "输入指标名称",required = true,paramType = "name",dataType = "String"),
//            @ApiImplicitParam(name = "weight",value = "输入指标名称",required = true,paramType = "weight",dataType = "String"),
//            @ApiImplicitParam(name = "pid",value = "输入指标名称",required = true,paramType = "pid",dataType = "Integer"),
//            @ApiImplicitParam(name = "sort",value = "输入指标名称",required = true,paramType = "sort",dataType = "Integer")
//    })
    public Map insertindex(@RequestParam("name")String name, @RequestParam("weight")String weight, @RequestParam("pid")Integer pid, @RequestParam("sort")Integer sort){      //增加
        Map result = new HashMap();
        Integer insert = indexService.insertindex(name,weight,pid,sort);
        result.put("insertindex",insert);
        return result;
    }

    @RequestMapping("/deleteIndex")
    @ResponseBody
    @ApiOperation(value = "删除单个指标",httpMethod = "POST")
    public int deleteindex(@RequestParam Integer id){              //删除节点和叶，目前只能删除选中的那一个，修改中。。。。
        int delete = indexService.deleteindex(id);
        return delete;
    }

    @RequestMapping("/updateIndex1")
    @ResponseBody
    @ApiOperation(value = "修改指标名称",httpMethod = "POST")
    public Integer  updateindex1(@RequestParam("name")String name,@RequestParam("id")Integer id){      //修改指标名称
        Integer update = indexService.updateindex1(name,id);
        return update;
    }

    @RequestMapping("/updateIndex2")
    @ResponseBody
    @ApiOperation(value = "修改指标权重",httpMethod = "POST")
    public Integer  updateindex2(@RequestParam("weight")String weight,@RequestParam("id")Integer id){      //修改指标权重
        Integer update = indexService.updateindex2(weight,id);
        return update;
    }

    @RequestMapping("/selectIndexOption")
    @ResponseBody
    @ApiOperation(value = "查询你单个指标",httpMethod = "POST")
    public Map  selectIndexOption(@RequestParam Integer id){                            //点击指标名称，显示查询名称和权重以及选项
        Map result = new HashMap();
        List<Index> selectindex1 = indexService.selectindex1(id);
        List<Option> selectoption = indexService.selectoption();
        result.put("selectindex1",selectindex1);
        result.put("selectoption",selectoption);
        return result;
    }

    @RequestMapping( "/insertOption")
    @ResponseBody
    @ApiOperation(value = "指标选项",httpMethod = "POST")
    public Map updateoption(@RequestParam String name1, @RequestParam Integer fraction1, @RequestParam String name2, @RequestParam Integer fraction2, @RequestParam String name3, @RequestParam Integer fraction3, @RequestParam String name4, @RequestParam Integer fraction4){                            //修改选项
        Integer s = indexService.deleteoption();
        Map result = new HashMap();
        Integer a = indexService.insertoption(name1,fraction1);
        Integer b = indexService.insertoption(name2,fraction2);
        Integer c = indexService.insertoption(name3,fraction3);
        Integer d = indexService.insertoption(name4,fraction4);
        result.put("s",s);
        result.put("a",a);
        result.put("b",b);
        result.put("c",c);
        result.put("d",d);
        return  result;
    }

    @RequestMapping( "/insertIndexF")
    @ResponseBody
    @ApiOperation(value = "增加父级指标",httpMethod = "POST")
    public Integer insertIndexF(@RequestParam String name,@RequestParam Integer pid){
        Integer integer1 = indexService.selectId(pid);
        Integer integer2 = indexService.selectSort(pid);
        Integer a = integer2 + 1;
        Integer integer3 = indexService.insertIndexF(name,integer1,a);
        return integer3;
    }

    @RequestMapping( "/insertIndexZ")
    @ResponseBody
    @ApiOperation(value = "增加子级指标",httpMethod = "POST")
    public Integer insertIndexZ(@RequestParam String name,@RequestParam Integer id){
        Integer integer = indexService.insertIndexF(name,id,0);
        return integer ;
    }
}
