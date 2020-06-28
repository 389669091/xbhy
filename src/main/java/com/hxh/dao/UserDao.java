package com.hxh.dao;

import com.hxh.entity.Page;
import com.hxh.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/23 15:18
 * @Description
 */
public class UserDao extends BaseDao {
//    public List<User> listAll( String name){
//        String sql ="select * from user where username like ?";
//        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),"%"+name+"%");
//    }
//    public void addUser(User user){
//        String sql="insert into user (username,password,email,real_name,age,sex,description,register_time,dept_id) values (?,?,?,?,?,?,?,?,?)";
//        template.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getRealName(),user.getAge(),user.getSex(),user.getDescription(),user.getRegisterTime(),user.getDeptId());
//    }
//
//    public User getUserByUserName(String userName){
//        String sql="select *from user where username=?";
//        return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),userName);
//    }
//    public User getUserById(Integer id){
//       String sql="select * from user where id=?";
//       return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
//    }
//    public void delete(Integer id){
//        String sql="delete from user where id=?";
//        template.update(sql,id);
//    }
//    public Integer getCount(){
//        String sql="select count(*) from user";
//        return template.queryForObject(sql,Integer.class);
//    }
//    public void update(User user){
//        String sql="update user set username=?,password=?,email=?,real_name=?,age=?,sex=?,description,register_time,dept_id where id=?";
//        template.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getRealName(),user.getAge(),user.getSex(),user.getDescription(),user.getRegisterTime(),user.getDeptId(),user.getId());
//    }

//       封装后  查询所有用户
public List<User> listAll(String username, String sex1, Page page) {
    Integer sex = Integer.valueOf(sex1);
    if (sex == -1) {
        String sql = "SELECT " +
                "d.id," +
                "d.name deptName," +
                "u.id," +
                "u.username," +
                "u.email," +
                "u.real_name realName," +
                "u.age," +
                "u.sex," +
                "u.description," +
                "u.register_time registerTime " +
                "from " +
                "user u " +
                "left join dept d ON u.dept_id = d.id " +
                "WHERE " +
                "u.username LIKE ? limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), "%" + username + "%", (page.getPageCurrent() - 1) * page.getSize(), page.getSize());
    } else {
        String sql = "SELECT " +
                "d.id," +
                "d.name deptName," +
                "u.id," +
                "u.username," +
                "u.email," +
                "u.real_name realName," +
                "u.age," +
                "u.sex," +
                "u.description," +
                "u.register_time registerTime " +
                "FROM " +
                "USER u " +
                "LEFT JOIN dept d ON u.dept_id = d.id " +
                "WHERE " +
                "u.username LIKE ? and sex=?  limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), "%" + username + "%", sex, (page.getPageCurrent() - 1) * page.getSize(), page.getSize());
    }
}

    //     查询所有记录总数
    public Integer getCount(String username, String sex1) {
        Integer sex = Integer.valueOf(sex1);
        if (sex == -1) {
            String sql = "select count(*) from user where username like ? ";
            return template.queryForObject(sql, Integer.class, "%" + username + "%");
        }
        String sql = "select count(*) from user where username like ? and sex=?";
        return template.queryForObject(sql, Integer.class, "%" + username + "%", sex);

    }

    //      根据用户名查询条件查询单条记录 用于判断用户是否存在
    public User findName(String username) {
        String sql = "select * from user where username=?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {
            return null;
        }
    }

    //      添加用户
    public void addUser(User user) {
        String sql = "insert into user(username,password,email,real_name,age,sex,description,register_time,dept_id)values(?,?,?,?,?,?,?,?,?)";
        template.update(sql, user.getUsername(), user.getPassword(), user.getEmail(),
                user.getRealName(), user.getAge(),user.getSex(), user.getDescription(), user.getRegisterTime(), user.getDeptId());
    }

    //      根据id查询用户，用于回显数据
    public User getUserById(Integer id) {
        String sql = "select * from user WHERE id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    //      修改用户数据
    public void updateUser(User user) {
        String sql = "update user set username=?,email=?,real_name=?,age=?,sex=?,description=?,dept_id=? where id=?";
        template.update(sql, user.getUsername(), user.getEmail(), user.getRealName(), user.getAge(), user.getSex(), user.getDescription(), user.getDeptId(), user.getId());
    }

    //      删除用户
    public void deleteUser(Integer id) {
        String sql = "delete from user where id=?";
        template.update(sql, id);
    }
    //用户修改密码
    public void updatePs(String username, String newPs) {
        String sql = "update user set password=? where username=? ";
        template.update(sql, newPs, username);
    }
}
