package com.hxh.controller;

import com.alibaba.fastjson.JSON;
import com.hxh.entity.Meeting;
import com.hxh.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/29 9:25
 * @Description
 */
@WebServlet("/meeting/*")
public class MeetingServlet extends BaseServlet {
    MeetingService meetingService=new MeetingService();
    public void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Meeting>list=meetingService.meetingList();
//        response.getWriter().write(JSON.toJSONString(list));
        request.setAttribute("list",list);
        request.getRequestDispatcher("/jsp/meeting/meeting.jsp").forward(request, response);
    }

}
