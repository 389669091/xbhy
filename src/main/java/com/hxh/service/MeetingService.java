package com.hxh.service;

import com.hxh.dao.MeetingDao;
import com.hxh.entity.Meeting;
import com.hxh.entity.Page;
import com.hxh.entity.User;
import com.hxh.enums.StatusEnum;
import com.hxh.utils.DateUtil;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/29 9:23
 * @Description
 */
public class MeetingService {
    MeetingDao meetingDao=new MeetingDao();
//    public List<Meeting> meetingList(){
//        return meetingDao.meetingList();
//    }

    public List<Meeting>findName(String title) {
        return meetingDao.findName(title);
    }


    public Page listAll(String title, String status1, String strPage) {
        Page page = new Page();
        if (!StringUtils.isEmpty(strPage)) {
            page.setPageCurrent(Integer.valueOf(strPage));
        }
        page.setCount(meetingDao.getCount(title, status1));
        List<Meeting> list = meetingDao.listAll(title, status1, page);
        page.setData(list);
        return page;
    }

    public Integer getCount(String title, String status1) {
        return meetingDao.getCount(title, status1);
    }

    public Meeting getMeetById(Integer id) {
        return meetingDao.getMeetById(id);
    }
}
