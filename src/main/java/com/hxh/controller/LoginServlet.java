package com.hxh.controller;

import com.alibaba.fastjson.JSON;
import com.hxh.constants.SysConstant;
import com.hxh.entity.User;
import com.hxh.enums.SysEnum;
import com.hxh.service.LoginService;
import com.hxh.service.UserService;
import com.hxh.utils.MdUtil;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * @auth hxh
 * @date 2020/6/23 0:32
 * @Description
 */
@WebServlet("/login/*")
public class LoginServlet extends BaseServlet {
    UserService userService=new UserService();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService loginService=new LoginService();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String remember=request.getParameter("remember");
        HttpSession session=request.getSession();
        User user= loginService.checkLogin(username,password);
        if (user==null){
            response.sendRedirect("/index.jsp");
        }else {
            session.setAttribute(SysConstant.SESSION_LOGIN,user);
            session.setMaxInactiveInterval(30*60);
            if ("1".equals(remember)){
                Cookie cookie=new Cookie (SysEnum.COOKIE_LOGIN_NAME.getValue(), URLEncoder.encode(JSON.toJSONString(user), "utf-8"));
                cookie.setMaxAge(7*24*60*60);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            request.getRequestDispatcher("/jsp/common/main.jsp").forward(request, response);
//            response.sendRedirect("/jsp/common/main.jsp");
    }
        }

    protected void forget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String newPs = request.getParameter("newPs");
        String code = request.getParameter("code");

        //判断账号
        boolean b = userService.findName(name);

        HttpSession session = request.getSession();
        //判断验证码是否正确
        Object obj = session.getAttribute(SysConstant.SESSION_CODE);
        if (obj != null) {
            //把session中的验证码和前端传递过来的验证做比较
            if (code.equals(obj.toString()) && !b) {
                //说明验证码正确 & 账号存在
                userService.updatePs(name, MdUtil.md5(newPs));
                System.out.println("修改成功！");
                response.sendRedirect("/index.jsp");
            } else {
                System.out.println("账号不存在或者验证码不正确");
                response.sendRedirect("/jsp/login/forget.jsp");
            }
        }

    }
}
