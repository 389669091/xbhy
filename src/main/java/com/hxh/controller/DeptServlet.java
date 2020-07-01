package com.hxh.controller;

import com.alibaba.fastjson.JSON;
import com.hxh.entity.Dept;
import com.hxh.service.DeptService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @auth hxh
 * @date 2020/6/23 0:32
 * @Description
 */
@WebServlet("/dept/*")
public class DeptServlet extends BaseServlet {
    private DeptService deptService = new DeptService();

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dept> list = deptService.listAll();
        PrintWriter pw = response.getWriter();
        String str = JSON.toJSONString(list);
        pw.write(str);
        pw.close();
    }

    public void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dept> list = deptService.listAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/jsp/dept/dept.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dept dept = new Dept();
        String name = request.getParameter("name");
        Map<String, String[]> map = request.getParameterMap();
        if (StringUtils.isEmpty(name)) {
            response.sendRedirect("dept/listAll");
            return;
        }
        try {
            BeanUtils.populate(dept, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        deptService.addDept(dept);
        response.sendRedirect("dept/listAll");
    }

    public void getDeptById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Dept dept = deptService.getDeptById(id);
        request.setAttribute("dept", dept);
        request.getRequestDispatcher("/jsp/dept/update.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dept dept = new Dept();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(dept, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        deptService.updateDept(dept);
        response.sendRedirect("/dept/listAll");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        deptService.deleteDept(id);
        response.sendRedirect("/dept/listAll");
    }
}
