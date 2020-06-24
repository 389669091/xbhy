package com.hxh.controller;

import com.alibaba.fastjson.JSON;
import com.hxh.entity.Menu;
import com.hxh.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auth hxh
 * @date 2020/6/23 0:34
 * @Description
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private MenuService menuService=new MenuService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Menu> list=menuService.list();
        List<Menu> parent=new ArrayList<>();
        List<Menu> son=new ArrayList<>();
        for (Menu m:list){
            if (m.getType()==1){
                parent.add(m);
            }else if (m.getType()==2){
                son.add(m);
            }
        }
        Map<String,List<Menu>> map=new HashMap<>();
        map.put("parent",parent);
        map.put("son",son);
        String strJson= JSON.toJSONString(map);
        PrintWriter pw=response.getWriter();
        pw.write(strJson);
        pw.close();

    }
    //初始
    // @Override
//    protected void service2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Menu> list=menuService.list();
//        String strJson=JSON.toJSONString(list);
//        PrintWriter pw=response.getWriter();
//        pw.write(strJson);
//        pw.close();
//    }
}
