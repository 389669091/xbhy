package com.hxh.dao;

import com.hxh.entity.Meeting;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/29 9:18
 * @Description
 */
public class MeetingDao extends BaseDao {
    public List<Meeting> meetingList(){
        String sql="select * from meeting";
        return template.query(sql,new BeanPropertyRowMapper<>(Meeting.class));
    }
}
