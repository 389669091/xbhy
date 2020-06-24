package com.hxh.controller;

import com.alibaba.fastjson.JSON;
import com.hxh.entity.Dept;
import com.hxh.service.DeptService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auth hxh
 * @date 2020/6/23 0:32
 * @Description
 */
@WebServlet("/dept/*")
public class DeptServlet extends BaseServlet {
    private DeptService deptService=new DeptService();

    protected void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dept> list =deptService.listAll();
        response.getWriter().write(JSON.toJSONString(list));
    }
}
