package com.zjazn.javaweb5.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向：
 *      response.sendRedirect(request.getContextPath()+"/index.jsp"); //叫浏览器去跳转， 像问路的一样
 *
 */
public class _7_Response重定向与设置响应信息 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("正在处理登录！");


        //重定向
        response.sendRedirect(request.getContextPath()+"/index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
