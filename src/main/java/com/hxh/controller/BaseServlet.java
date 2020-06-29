package com.hxh.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @auth hxh
 * @date 2020/6/23 0:31
 * @Description
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        String [] uris=uri.split("/");
        String method=uris[uris.length-1];
//        UserServlet userServlet=new UserServlet();
        //反射
        Class cla=this.getClass();
        try {
            Method m=cla.getDeclaredMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            m.setAccessible(true);
            m.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
