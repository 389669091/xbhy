package com.hxh.dao;

import com.hxh.entity.Dept;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/23 15:18
 * @Description
 */
public class DeptDao extends BaseDao {
    public List<Dept> listAll(){
        String sql ="select * from dept";
        return template.query(sql,new BeanPropertyRowMapper<Dept>(Dept.class));
    }
    public void addDept(Dept dept) {
        String sql = "insert into dept(name) values(?)";
        template.update(sql, dept.getName());
    }

    public Dept getDeptById(Integer id) {
        String sql = "select * from dept where id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Dept>(Dept.class), id);
    }

    public void updateDept(Dept dept) {
        String sql = "update dept set name=? where id=?";
        template.update(sql, dept.getName(), dept.getId());
    }

    public void deleteDept(Integer id) {
        String sql = "delete from dept where id=?";
        template.update(sql, id);
    }
}
