package com.hxh.service;

import com.hxh.dao.LoginDao;
import com.hxh.entity.User;
import com.hxh.utils.MdUtil;

/**
 * @auth hxh
 * @date 2020/6/28 10:50
 * @Description
 */
public class LoginService  {
    LoginDao loginDao=new LoginDao();
    public User checkLogin(String username,String password){
        User user=new User();
        String strPs= MdUtil.md5(password);
        user.setUsername(username);
        user.setPassword(strPs);
        return loginDao.checkLogin(user);
    }

}
