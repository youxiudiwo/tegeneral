package com.zuoshao.tegeneral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zuoshao
 * @date 2019/9/9 - 12:09
 */
@Controller
public class  HelloController{
    @RequestMapping("shuxingtest")
    public String gotoindex(){
        return "login";
    }
}
