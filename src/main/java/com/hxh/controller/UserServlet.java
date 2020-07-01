package com.hxh.controller;

import com.hxh.entity.Dept;
import com.hxh.entity.Page;
import com.hxh.entity.User;
import com.hxh.service.DeptService;
import com.hxh.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    private UserService userService = new UserService();
    private DeptService deptService = new DeptService();
//    //优化前
////    @Override
////    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String uri = request.getRequestURI();
////        if (uri.endsWith("list")){
////            list(request,response);
////        }
////    }

    //    查询所有用户
    public void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        username = username == null ? "" : username;
        String sex = request.getParameter("sex");
        sex = sex == null ? "-1" : sex;
        String strPage = request.getParameter("page");
//以分页的形式显示查询出来的数据
        Page page = userService.listAll(username, sex, strPage);
        request.setAttribute("username", username);
        request.setAttribute("sex", sex);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/jsp/user/user.jsp").forward(request, response);
    }

    //    根据用户名，添加用户时不能重名
    public void findName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        Boolean b = userService.findName(username);
        PrintWriter pw = response.getWriter();
        if (StringUtils.isEmpty(username)) {
            return;
        }
        if (b) {
            pw.write("1");
        } else {
//           账户存在
            pw.write("0");
        }
        pw.close();
    }

    //    添加用户
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if (StringUtils.isEmpty(username)) {
            response.sendRedirect("/user/listAll");
            return;
        }
        User user = new User();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userService.addUser(user);
        response.sendRedirect("/user/listAll");

    }

    //    根据id查询用户，用于修改用户回显数据
    public void getUserById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (StringUtils.isEmpty(id)) {
            return;
        }
        User user = userService.getUserById(Integer.valueOf(id));
        List<Dept> deptList = deptService.listAll();
        request.setAttribute("deptList", deptList);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/jsp/user/update.jsp").forward(request, response);
    }

    //   修改用户信息
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if (StringUtils.isEmpty(username)) {
            response.sendRedirect("/user/listAll");
            return;
        }
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userService.updateUser(user);
        response.sendRedirect("/user/listAll");
    }

    //  删除用户
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        userService.deleteUser(Integer.valueOf(id));
        response.sendRedirect("/user/listAll");
    }

}

