package com.zuoshao.tegeneral.service.serviceimpl;

import com.zuoshao.tegeneral.bean.InOp;
import com.zuoshao.tegeneral.bean.Index;
import com.zuoshao.tegeneral.bean.Option;
import com.zuoshao.tegeneral.mapper.IndexMapper;
import com.zuoshao.tegeneral.service.IndexService;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class IndexServiveImpl implements IndexService {

    @Autowired
    IndexMapper indexmapper;

    @Override
    public List<Map<String,Object>> selectIndex(int pid){
        List<Index> list = indexmapper.selectindex();
        return buildTree(pid,list);
    }
    public List<Map<String,Object>> buildTree(int pid, List<Index> list){
        List<Map<String, Object>> result = new LinkedList<>();
        // 1.边界条件
        List<Index> childList = list.stream().filter(item -> item.getPid()==pid).collect(Collectors.toList());
        // 3.返回段
        if(childList.isEmpty()) return result;

        // 2.前进段
        childList.stream().forEach(item->{
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("key", item.getId());
            map.put("title", item.getName());
            map.put("pid", item.getPid());
            map.put("sort", item.getSort());
            map.put("weight", item.getWeight());

            List<Map<String, Object>> childs = buildTree(item.getId(), list);
            if(!childs.isEmpty()){
                map.put("children", childs);
            }
            result.add(map);
        });

        return result;
    }

    @Override
    public Integer insertindex(@Param("id")Integer id,@Param("name")String name, @Param("weight")String weight, @Param("pid")Integer pid, @Param("sort")Integer sort){
        return indexmapper.insertindex(id,name,weight,pid,sort);
    }

    @Override
    public int deleteindex(Integer id){
        return indexmapper.deleteindex(id);
    }

    @Override
    public  Integer updateindex1(@Param("name")String name,@Param("weight")String weight,@Param("id")Integer id){
        return indexmapper.updateindex1(name,weight,id);
    }
//    @Override
//    public  Integer updateindex2(@Param("weight")String weight,@Param("id")Integer id){
//        return indexmapper.updateindex2(weight,id);
//    }

    @Override
    public List<Index> selectindex1(Integer id){
        return indexmapper.selectindex1(id);
    }

    @Override
    public List<Option> selectoption(Integer id){
        return indexmapper.selectoption(id);
    }

    @Override
    public Integer insertoption(@Param("id")Integer id, @Param("name")String name, @Param("fraction")String fraction){
        return indexmapper.insertoption(id,name,fraction);
    }

    @Override
    public Integer deleteoption(){
        return indexmapper.deleteoption();
    }

    @Override
    public Integer selectId(Integer pid){
        return indexmapper.selectId(pid);
    }

    @Override
    public Integer selectSort(Integer pid){
        return indexmapper.selectSort(pid);
    }

    @Override
    public Integer insertIndexF(@Param("name")String name, @Param("pid")Integer pid, @Param("sort")Integer sort){
        return indexmapper.insertIndexF(name,pid,sort);
    }

    @Override
    public List<InOp> selectIn_Op(Integer id){
        return indexmapper.selectIn_Op(id);
    }

    @Override
    public Integer updateOption(@Param("name")String name,@Param("fraction")String fraction,@Param("id")Integer id){
        return indexmapper.updateOption(name,fraction,id);
    }

    @Override
    public Integer selectIdOption(Integer id){
        return indexmapper.selectIdOption(id);
    }
    @Override
    public Integer selectIdIndex(Integer id){
        return  indexmapper.selectIdIndex(id);
    }

    @Override
    public Integer insertIn_Op(@Param("iid")Integer iid,@Param("oid")Integer oid){
        return indexmapper.insertIn_Op(iid,oid);
    }
}
