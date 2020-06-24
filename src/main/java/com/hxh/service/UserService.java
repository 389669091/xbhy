package com.hxh.service;

import com.hxh.dao.MenuDao;
import com.hxh.dao.UserDao;
import com.hxh.entity.Menu;
import com.hxh.entity.User;

import java.util.Date;
import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/23 0:27
 * @Description
 */
public class UserService {
    private UserDao userDao=new UserDao();
    public List<User> list(){
        return userDao.listAll();
    }
    public void addUser(User user){
        user.setId(null);
        user.setRegisterTime(new Date());
        userDao.addUser(user);
    }
}
