package com.zuoshao.tegeneral.service.serviceimpl;

import com.zuoshao.tegeneral.bean.Index;
import com.zuoshao.tegeneral.mapper.IndexMapper;
import com.zuoshao.tegeneral.service.IndexService;
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
            map.put("id", item.getId());
            map.put("name", item.getName());
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
    public Integer insertindex(@Param("name")String name, @Param("weight")String weight, @Param("pid")Integer pid, @Param("sort")Integer sort){
        return indexmapper.insertindex(name,weight,pid,sort);
    }

    @Override
    public int deleteindex(Integer id){
        return indexmapper.deleteindex(id);
    }

    @Override
    public  Integer updateindex(@Param("name")String name, @Param("weight")String weight,@Param("id")Integer id){
        return indexmapper.updateindex(name,weight,id);
    }

}
