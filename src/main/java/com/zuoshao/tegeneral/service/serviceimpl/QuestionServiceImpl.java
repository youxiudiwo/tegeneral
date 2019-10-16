package com.zuoshao.tegeneral.service.serviceimpl;

import com.zuoshao.tegeneral.bean.*;
import com.zuoshao.tegeneral.bean.beanexa.QustionBatch;
import com.zuoshao.tegeneral.mapper.*;
import com.zuoshao.tegeneral.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zuoshao
 * @date 2019/9/25 - 8:53
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    Userrolemapper userrolemapper;
    @Autowired
    Studentclassmapper studentclassmapper;
    @Autowired
    RelationshipMapper relationshipMapper;
    @Autowired
    Usermapper usermapper;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    QuInMapper quinmapper;


    @Override
    public Studentclass getstudentclass(Studentclass studentclass) {
        Studentclass studentclass1 = studentclassmapper.selectOne(studentclass);
        return studentclass;
    }

    @Override
    public List<User> getclassteacher(Relationship relationship) {
        List<Relationship> select = relationshipMapper.select(relationship);
        List<Integer> lists = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        User user = new User();
        List<User> users=new ArrayList<>();
        for (Relationship relationship1:select) {
            if (set.add(relationship1.getTeacherid())) {
                lists.add(relationship1.getTeacherid());
            }
        }
        for (Integer list:lists) {
            user.setId(list);
            User select1 = usermapper.selectOne(user);
            users.add(select1);
        }
        return users;
    }

    @Override
    public Questionnaire getqeustionexa(Questionnaire questionnaire) {
        Questionnaire selectquestionexa = userrolemapper.selectquestionexa(questionnaire);
        return selectquestionexa;
    }

    @Override
    public List<QustionBatch> getquestionall() {
        List<QustionBatch> selectquestionall = userrolemapper.selectquestionall();
        return selectquestionall;
    }

    @Override
    public Integer addquestion(Questionnaire questionnaire) {
        int insert = questionMapper.insert(questionnaire);
        return insert;
    }

    @Override
    public Questionnaire getaquestion(Questionnaire questionnaire) {
        Questionnaire select = questionMapper.selectOne(questionnaire);
        return select;
    }

    @Override
    public List<Questionnaire> getallquestion(Questionnaire questionnaire) {
        List<Questionnaire> select = questionMapper.select(questionnaire);
        return select;
    }

    @Override
    public Questionnaire selectnewupdate() {
        Questionnaire selectnewupdate = userrolemapper.selectnewupdate();
        return selectnewupdate;
    }

    @Override
    public Questionnaire insertquestion(Questionnaire questionnaire) {
        Questionnaire insertquestion = userrolemapper.insertquestion(questionnaire);
        return insertquestion;
    }

    @Override
    public Integer addquestionindex(QuIn quin) {
        int insert = quinmapper.insert(quin);
        return insert;
    }

    @Override
    public Integer selectZice(User user) {
        Integer integer = userrolemapper.selectZice(user);
        return integer;
    }

    @Override
    public List<Integer> selectTeacherP(User user){
        return userrolemapper.selectTeacherP(user);
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
