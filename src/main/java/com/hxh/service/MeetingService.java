package com.hxh.service;

import com.hxh.dao.MeetingDao;
import com.hxh.entity.Meeting;

import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/29 9:23
 * @Description
 */
public class MeetingService {
    MeetingDao meetingDao=new MeetingDao();
    public List<Meeting> meetingList(){
        return meetingDao.meetingList();
    }
}
