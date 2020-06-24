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
        return template.query(sql,new BeanPropertyRowMapper<>(Dept.class));
    }

}
