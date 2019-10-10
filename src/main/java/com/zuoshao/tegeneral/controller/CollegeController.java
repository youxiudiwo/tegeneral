package com.zuoshao.tegeneral.controller;

import com.zuoshao.tegeneral.bean.College;
import com.zuoshao.tegeneral.service.CollegeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(description = "学院管理接口")
@Controller
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/addCollege")
    @ResponseBody
    public Integer addCollege(College college){
        college.setName("数字媒体");
        return  collegeService.addCollege(college);

    }
    @RequestMapping("/deleteCollege")
    @ResponseBody
    public Integer deleteCollege(College college){
        return  collegeService.deleteCollege(college);

    }
    @RequestMapping("/updateCollege")
    @ResponseBody
    public Integer updateCollege(College college){
        return  collegeService.updateCollege(college);

    }
    @RequestMapping("/getCollege")
    @ResponseBody
    public List<College> getCollege(){
        return  collegeService.getCollege();
    }


}
