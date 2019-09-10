package com.zuoshao.tegeneral.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zuoshao
 * @date 2019/3/14 - 18:02
 * 拦截器类，拦截所有除开静态资源方法的请求
 * deng
 */

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username =(String) session.getAttribute("username");
        System.out.println("进入拦截器");
        if (username == null){
            request.setAttribute("mag","您还没有登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
//            response.sendRedirect(request.getContextPath()+"/login.html");
            return false;
        }else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
