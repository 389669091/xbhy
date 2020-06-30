package com.hxh.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hxh.constants.SysConstant;
import com.hxh.entity.User;
import com.hxh.enums.SysEnum;
import com.hxh.service.LoginService;
import com.hxh.service.UserService;
import com.hxh.utils.MdUtil;
import com.hxh.utils.WeChatUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.UUID;

/**
 * @auth hxh
 * @date 2020/6/23 0:32
 * @Description
 */
@WebServlet("/weChat/*")
public class WeChatServlet extends BaseServlet {
    UserService userService=new UserService();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Properties prop=new Properties();
        prop.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
        String appid=prop.getProperty("wx.AppID");
        String redirect_uri=prop.getProperty("wx.redirect_uri");
        String url = "https://open.weixin.qq.com/connect/qrconnect?response_type=code"+
                "&appid=" + appid +
                "&redirect_uri=" + URLEncoder.encode(redirect_uri) +
                "&scope=snsapi_login";
        response.sendRedirect(url);
    }

    protected void wxLoginCallBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WeChatUtil weChatUtil = new WeChatUtil();
        HttpSession session = request.getSession();
        String code = request.getParameter("code");

        // 加载配置文件
        Properties prop = new Properties();
        prop.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));

        // https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code

        String appid = prop.getProperty("wx.AppID");
        String AppSecret = prop.getProperty("wx.AppSecret");

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid +
                "&secret=" + AppSecret +
                "&code=" + code +
                "&grant_type=authorization_code";

        // 获取AccessToken、openid等数据
        JSONObject authInfo = weChatUtil.auth(url);

        System.out.println("authInfo: " + authInfo);
        url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + authInfo.getString("access_token") +
                "&openid=" + authInfo.getString("openid");
        JSONObject userInfo = weChatUtil.getUserInfo(url);
        System.out.println("userInfo: " + userInfo);

        User user =userService.findByWxOpenid(userInfo.getString("openid"));
        if (user==null){
             user=new User();
            user.setPic(userInfo.getString("headimgurl"));
            user.setRealName(userInfo.getString("nickname"));
            user.setSex(userInfo.getInteger("sex"));
            user.setUsername(UUID.randomUUID().toString().substring(36 - 15));
            user.setWxOpenid(userInfo.getString("openid"));
            userService.addUser(user);
        }
        session.setAttribute(SysConstant.SESSION_LOGIN, user);
        session.setAttribute("user1",user);
//        response.sendRedirect("/jsp/common/main.jsp");
        request.getRequestDispatcher("/jsp/common/main.jsp").forward(request,response);
    }
}
