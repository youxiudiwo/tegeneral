package com.zuoshao.tegeneral.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author zuoshao
 * @date 2019/3/12 - 16:06
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//        获取请求头后边带的区域信息字符串
        String l=httpServletRequest.getParameter("l");

        Locale locale=Locale.getDefault();
        //判定是否为空，不为空就用默认的
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            //0代表的是前面的语言代码，1代表国家代码
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }



}
