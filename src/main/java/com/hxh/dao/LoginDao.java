package com.hxh.dao;

import com.hxh.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * @auth hxh
 * @date 2020/6/28 10:38
 * @Description
 */
public class LoginDao extends BaseDao {

  public User checkLogin(User user){
      String sql="select * from user where username=? and password=?";
      try {
          return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),user.getUsername(),user.getPassword());
      } catch (DataAccessException e) {
          return null;
      }
  }


}
