package com.zjazn.javaweb5.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * _6_Request转发与获取前台数据：
 *   获取参数： request.getParameter（）普通kv 、request.getParameterValues（可以获取多选框的内容 ）
 *
 *   转发：  request.getRequestDispatcher(request.getContextPath()+"/login.jsp");  转发路径不变是发生在服务器上的跳转
 *
 *   前端跳转到controller ：  <form method="post" action="${pageContext.request.contextPath}/logon">
 */
public class _6_Request转发与获取前台数据 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("正在处理注册！");
        //获取前端传递的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbys = request.getParameterValues("hobbys");
        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(hobbys));
        System.out.println(request.getContextPath());
        //转发
        request.getRequestDispatcher("/gvc").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
