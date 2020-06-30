package com.hxh.filters;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxh.constants.SysConstant;
import com.hxh.entity.User;
import com.hxh.enums.SysEnum;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @auth hxh
 * @date 2020/6/23 0:27
 * @Description
 */
@WebFilter("/*")
public class SysFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        String contentType = request.getHeader("Accept");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        /*response.setContentType("text/html;charset=UTF-8");*/
        HttpSession session = request.getSession();
//        String uri = request.getRequestURI();
//        //登录，默认的，/login
//        if (uri.endsWith("/index.jsp")) {
//            Cookie[] cookies = request.getCookies();
//            for (Cookie c : cookies) {
//                String cookieName = c.getName();
//                //把cookie中的登录信息放到session中
//                if (SysEnum.COOKIE_LOGIN_NAME.getValue().equals(cookieName)) {
//                    String cookieValue = c.getValue();
//                    cookieValue = URLDecoder.decode(cookieValue, "utf-8");
//                    ObjectMapper om=new ObjectMapper();
//                    User user = om.readValue(cookieValue,User.class);
//                    session.setAttribute(SysConstant.SESSION_LOGIN, user);
//                    session.setMaxInactiveInterval(30 * 60);
//                    //如果有cookie.则直接跳转到成功页面
//                    filterChain.doFilter(request, response);
//                    request.getRequestDispatcher("/jsp/common/main.jsp").forward(request, response);
//                    return;
//                }
//            }
//        }
//
//        else if (uri.endsWith("/")
//                || uri.endsWith("/forget.jsp")
//                || uri.endsWith("/email")
//                ||uri.endsWith("/meeting/listAll")
//                ||uri.contains("img")
//                ||uri.contains("static")
//                ||uri.contains("login")
//                ||uri.contains("weChat")
//        ) {
//            //直接放行
//        } else {
//            //判断是否有session
//            Object obj = session.getAttribute(SysConstant.SESSION_LOGIN);
//            if (obj == null) {
//                //说明session中没有值
//                //非法登陆，强制跳转到登录页面重新登录
//                request.getRequestDispatcher("/index.jsp").forward(request, response);
//            } else {
//                //session中有登陆信息
//
//            }
//        }
        filterChain.doFilter(request,response);
    }
}


