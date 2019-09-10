package com.zuoshao.tegeneral.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class AntDesignController {
//    配置通配符拦截多个地址
    @RequestMapping(value = {
            "/",
            "/index",
            "/user",
            "/user/"
    })
    public String fowardIndex(){
        return "index";
    }
}
