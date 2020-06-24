package com.hxh.dao;

import com.hxh.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/23 15:18
 * @Description
 */
public class UserDao extends BaseDao {
    public List<User> listAll(){
        String sql ="select * from user";
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class));
    }
    public void addUser(User user){
        String sql="insert into user (username,password,email,real_name,age,gender,description,register_time,dept_id) values (?,?,?,?,?,?,?,?,?)";
        template.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getRealName(),user.getAge(),user.getGender(),user.getDescription(),user.getRegisterTime(),user.getDeptID());
    }
}
