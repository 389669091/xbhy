package com.hxh.dao;

import com.hxh.entity.Meeting;
import com.hxh.entity.Page;
import com.hxh.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/29 9:18
 * @Description
 */
public class MeetingDao extends BaseDao {
//    public List<Meeting> meetingList(){
//        String sql="select * from meeting";
//        return template.query(sql,new BeanPropertyRowMapper<>(Meeting.class));
//    }

    public List<Meeting> findName(String title) {
        String sql="select * from meeting where title like ? ";
        return template.query(sql,new BeanPropertyRowMapper<>(Meeting.class),"%"+title+"%");
    }


    public List<Meeting> listAll(String title, String status1, Page page) {
        Integer status = Integer.valueOf(status1);
        if (status == -1) {
            String sql = "select * from meeting where title like ? limit ?,?";
            return template.query(sql, new BeanPropertyRowMapper<>(Meeting.class), "%" + title + "%", (page.getPageCurrent() - 1) * page.getSize(), page.getSize());
        } else {
            String sql = "select * from meeting where title like ? and status=? limit ?,?";
            return template.query(sql, new BeanPropertyRowMapper<>(Meeting.class), "%" + title + "%", status, (page.getPageCurrent() - 1) * page.getSize(), page.getSize());
        }
    }

    //     查询所有记录总数
    public Integer getCount(String title, String status1) {
        Integer status = Integer.valueOf(status1);
        if (status == -1) {
            String sql = "select count(*) from meeting where title like ? ";
            return template.queryForObject(sql, Integer.class, "%" + title + "%");
        }
        String sql = "select count(*) from meeting where title like ? and status=?";
        return template.queryForObject(sql, Integer.class, "%" + title + "%", status);

    }
    public Meeting getMeetById(Integer id) {
        String sql = "select * from meeting WHERE id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Meeting.class), id);
    }

}
