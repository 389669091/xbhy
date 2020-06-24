package com.hxh.dao;

import com.hxh.entity.Menu;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/23 0:30
 * @Description
 */
public class MenuDao extends BaseDao {
    public List<Menu> list(){
        String sql="select * from menu";
        return template.query(sql,new BeanPropertyRowMapper<Menu>(Menu.class));
    }
}
