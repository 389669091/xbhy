package com.hxh.controller;

import com.hxh.entity.User;
import com.hxh.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @auth hxh
 * @date 2020/6/23 0:36
 * @Description
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserService userService=new UserService();
    //优化前
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String uri = request.getRequestURI();
//        if (uri.endsWith("list")){
//            list(request,response);
//        }
//    }


    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User>list=userService.list();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/jsp/user/user.jsp").forward(request,response);
//        response.sendRedirect("");
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Map<String ,String[]> map= request.getParameterMap();
    User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userService.addUser(user);
//        response.sendRedirect("/user/list");
    }
}
