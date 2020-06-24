package com.hxh.service;

import com.hxh.dao.MenuDao;
import com.hxh.entity.Menu;

import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/23 0:27
 * @Description
 */
public class MenuService {
    private MenuDao menuDao=new MenuDao();
    public List<Menu> list(){
        return menuDao.list();
    }
}
