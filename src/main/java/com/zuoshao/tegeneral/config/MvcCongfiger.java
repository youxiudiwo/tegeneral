package com.zuoshao.tegeneral.config;

import com.zuoshao.tegeneral.component.LoginHandlerInterceptor;
import com.zuoshao.tegeneral.component.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author zuoshao
 * @date 2019/3/11 - 11:59
 */

//以前1.5版本是继承webmvcconfigurationsupport 父类 WebMvcConfigurationSupport
@Configuration
public class MvcCongfiger extends WebMvcConfigurationSupport {
    @Autowired
    private LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        System.out.println("拦截器路径");
        //不用处理静态资源
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("list.html","add.html")
                .excludePathPatterns("/login.html","/logines","/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController("login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:templates/")
                .addResourceLocations("classpath:/public/");
//        super.addResourceHandlers(registry);
    }




    @Bean
    public LocaleResolver localeResolver()
    {
        return new MyLocaleResolver();
    }

//    @Bean
//    public WebMvcConfigurationSupport webMvcConfigurationSupport(){
//        WebMvcConfigurationSupport support = new WebMvcConfigurationSupport(){
//            @Override
//            protected void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/login").setViewName("login");
//                // registry.addViewController("/login.html").setViewName("login");
//            }
//
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                //registry.addResourceHandler("/resources/static/**").addResourceLocations("classpath:/static/");
//                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/resources/static/");
//                super.addResourceHandlers(registry);
//            }
//        };
//        return support;
//    }



}
