package com.hxh.controller;

import com.hxh.entity.Dept;
import com.hxh.entity.Meeting;
import com.hxh.entity.Page;
import com.hxh.entity.User;
import com.hxh.service.MeetingService;
import org.springframework.util.StringUtils;

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
    MeetingService meetingService = new MeetingService();

    public void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    public void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String title=request.getParameter("title");
//        if (title==null){
//            title="";
//        }
//        List<Meeting>list=meetingService.findName(title);
//        request.setAttribute("list",list);
//        request.getRequestDispatcher("/jsp/meeting/meeting.jsp").forward(request,response);
//    }
        String title = request.getParameter("title");
        title = title == null ? "" : title;
        String status = request.getParameter("status");
        status = status == null ? "-1" : status;
        String strPage = request.getParameter("page");
        //以分页的形式显示查询出来的数据
        Page page = meetingService.listAll(title, status, strPage);
        request.setAttribute("title", title);
        request.setAttribute("status", status);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/jsp/meeting/meeting.jsp").forward(request, response);
    }

    public void getMeetById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (StringUtils.isEmpty(id)) {
            return;
        }
        Meeting meeting =meetingService.getMeetById(Integer.valueOf(id));
        request.setAttribute("meeting", meeting);
        request.getRequestDispatcher("/jsp/meeting/update.jsp").forward(request, response);
    }
}
