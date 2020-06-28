package com.hxh.service;

import com.hxh.dao.DeptDao;
import com.hxh.entity.Dept;

import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/25 0:27
 * @Description
 */
public class DeptService {
    private DeptDao deptDao=new DeptDao();
    public List<Dept> listAll(){
        return deptDao.listAll();
    }
    public void addDept(Dept dept){
        deptDao.addDept(dept);
    }

    public Dept getDeptById(Integer id){
        return deptDao.getDeptById(id);
    }

    public void updateDept(Dept dept){
        deptDao.updateDept(dept);
    }

    public void deleteDept(Integer id){
        deptDao.deleteDept(id);
    }
}
