package com.hxh.service;

import com.hxh.dao.DeptDao;
import com.hxh.dao.MenuDao;
import com.hxh.entity.Dept;
import com.hxh.entity.Menu;

import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/23 0:27
 * @Description
 */
public class DeptService {
    private DeptDao deptDao=new DeptDao();
    public List<Dept> listAll(){
        return deptDao.listAll();
    }
}
