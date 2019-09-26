package com.zuoshao.tegeneral.service.serviceimpl;

import com.zuoshao.tegeneral.bean.Index;
import com.zuoshao.tegeneral.mapper.IndexMapper;
import com.zuoshao.tegeneral.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zuoshao
 * @date 2019/9/25 - 8:53
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    IndexMapper indexmapper;
    @Override
    public List<Map<String, Object>> getindexalltrue(Integer id) {
        List<Index> indices = indexmapper.selectAll();
        return buildTree(id,indices);
    }


    public List<Map<String, Object>> buildTree(Integer pid, List<Index> list){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        // 1.边界条件
        List<Index> childList = list.stream().filter(item -> item.getPid()==pid).collect(Collectors.toList());
        // 3.返回段
        if(childList.isEmpty()) return result;

//        // 2.前进段
//        childList.stream().forEach(item->{
//            Map<String, Object> map = new HashMap<>();
//            map.put("id", item.getId());
//            map.put("code", item.getCode());
//            map.put("title", item.getName());
//            map.put("pid", item.getParent_id());
//            map.put("href", item.getPath());
//            map.put("status", item.getStatus());
//
//            List<Map<String, Object>> childs = buildTree(item.getId(), list);
//            if(!childs.isEmpty()){
//                map.put("children", childs);
//            }
//
//            result.add(map);
//        });

        return result;
    }
}
