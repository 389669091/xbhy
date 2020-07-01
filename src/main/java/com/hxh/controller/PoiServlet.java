package com.hxh.controller;

import com.hxh.service.UserService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @auth hxh
 * @date 2020/7/1 11:12
 * @Description
 */
@WebServlet("/poi/*")
public class PoiServlet extends BaseServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserService();
        String username=request.getParameter("username");
        Workbook wb=userService.listForExcel(username);
        response.setHeader("Content-Disposition", "attachment;filename=" + new String("用户信息表.xlsx".getBytes("utf-8"), "iso-8859-1"));
        response.setContentType("application/ynd.ms-excel;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        wb.write(out);
        out.flush();
        out.close();
    }
}
