package com.hxh.service;

import com.hxh.dao.MenuDao;
import com.hxh.dao.UserDao;
import com.hxh.entity.Menu;
import com.hxh.entity.Page;
import com.hxh.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.Date;
import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/23 0:27
 * @Description
 */
public class UserService {
    private UserDao userDao=new UserDao();
//    public List<User> list(String name){
//        return userDao.listAll(name);
//    }
//    public void addUser(User user){
//        user.setId(null);
//        user.setRegisterTime(new Date());
//        userDao.addUser(user);
//    }
//    public User getUserById(Integer id){
//       return  userDao.getUserById(id);
//    }
//    public void delete(Integer id){
//        userDao.delete(id);
//    }
//    public Integer getCount(){
//        return userDao.getCount();
//    }
//    public void update(User user){
//        userDao.update(user);
//    }

    //    封装后
    public Page listAll(String username, String sex1, String strPage) {
        Page page = new Page();
        if (!StringUtils.isEmpty(strPage)) {
            page.setPageCurrent(Integer.valueOf(strPage));
        }
        page.setCount(userDao.getCount(username, sex1));
        List<User> list = userDao.listAll(username, sex1, page);
        page.setData(list);
        return page;
    }

    public Integer getCount(String username, String sex1) {
        return userDao.getCount(username, sex1);
    }

    public void addUser(User user) {
        user.setId(null);
//        user.setRegisterTime(new Date());
        user.setRegisterTime(new Date());
        userDao.addUser(user);
    }

    public Boolean findName(String username) {
        User user = userDao.findName(username);
        if (user != null) {
//            账户已存在
            return false;
        }
//        数据不存在则为真
        return true;
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
    public void updatePs(String username, String newPs) {
        userDao.updatePs(username, newPs);
    }

    public void updatePic(Integer id, String pic) {
        userDao.updatePic(id, pic);
    }
}
