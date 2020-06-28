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
    private UserService userService=new UserService();
    private DeptService deptService=new DeptService();
//    //优化前
////    @Override
////    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String uri = request.getRequestURI();
////        if (uri.endsWith("list")){
////            list(request,response);
////        }
////    }
//    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name=request.getParameter("username");
//        if (name==null){
//            name="";
//        }
//        List<User>list=userService.list(name);
////        request.setAttribute("username",name);
//        request.setAttribute("list",list);
//        request.getRequestDispatcher("/jsp/user/user.jsp").forward(request,response);
//////        response.sendRedirect("");
//
//
//    }
//    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    Map<String ,String[]> map= request.getParameterMap();
//    User user=new User();
//        try {
//            BeanUtils.populate(user,map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        userService.addUser(user);
//        response.sendRedirect("/user/list");
//    }
//
//    public void getUserById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//     Integer id=Integer.valueOf(request.getParameter("id")) ;
//      User user = userService.getUserById(id);
//      List<Dept>deptList=deptService.listAll();
//      request.setAttribute("user",user);
//      request.setAttribute("deptList",deptList);
//      request.getRequestDispatcher("/jsp/user/update.jsp").forward(request,response);
////     response.sendRedirect("/jsp/user/update.jsp");
//    }
//    public void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        Integer page=Integer.valueOf(request.getParameter("page"));
//        String strPage=request.getParameter("page");
//        Integer page=1;
//        if (!StringUtils.isEmpty(strPage)){
//
//        }
//    }
//
//    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        if (StringUtils.isEmpty(id)) {
//            return;
//        }
//        userService.delete(Integer.valueOf(id));
//        response.sendRedirect("/user/list");
//    }
//    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//    查询所有用户
public void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String username = request.getParameter("username");
    username = username == null ? "" : username;
    String sex = request.getParameter("sex");
    sex = sex == null ? "-1" : sex;
    String strPage=request.getParameter("page");

    Page page=userService.listAll(username,sex,strPage);
    request.setAttribute("username",username);
    request.setAttribute("sex",sex);
    request.setAttribute("page",page);
    request.getRequestDispatcher("/jsp/user/user.jsp").forward(request,response);
}

    //    public void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String username=request.getParameter("username");
//        String strPage=request.getParameter("page");
//        String sex=request.getParameter("sex");
//        if (StringUtils.isEmpty(username)){
//            username="";
//        }
//        if (StringUtils.isEmpty(sex)){
//            sex="-1";
//        }
//        Integer page=1;
//        if ( !StringUtils.isEmpty(strPage)){
//            page =Integer.valueOf(strPage);
//            if (page<=0){
//                page=1;
//            }
//        }
//        Integer count=userService.getCount(username,sex);
//        Integer pageCount=count%5==0?count/5:count/5+1;
//        if (page>=pageCount){
//            page=pageCount;
//        }
//        List<User> list=userService.listAll(username,sex,page);
//        request.setAttribute("list",list);
//        request.setAttribute("page",page);
//        request.setAttribute("pageCount",pageCount);
//        request.setAttribute("count",count);
//        request.setAttribute("username",username);
//        request.setAttribute("sex",sex);
//        request.getRequestDispatcher("/jsp/user/user.jsp").forward(request,response);
//    }


//    根据用户名，添加用户时不能重名
    public void findName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        Boolean b = userService.findName(username);
        PrintWriter pw = response.getWriter();
        if (StringUtils.isEmpty(username)){
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
        String username=request.getParameter("username");
        if (StringUtils.isEmpty(username)){
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
        String id=request.getParameter("id");
        if (StringUtils.isEmpty(id)){
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
        String username=request.getParameter("username");
        if (StringUtils.isEmpty(username)){
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
        String id=request.getParameter("id");
        userService.deleteUser( Integer.valueOf(id));
        response.sendRedirect("/user/listAll");
    }
}

