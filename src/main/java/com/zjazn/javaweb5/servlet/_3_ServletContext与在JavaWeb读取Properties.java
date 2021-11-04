package com.zjazn.javaweb5.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * 1） ServletContext是在任何Servlet上代表的是app数据容器，可以存取数据
 *     1-1）this.getServletContext(); 获取ServletContext 容器， 除了可以在容器中进行数据的存取外，也可以用来进行请求转发
 *
 *     1-2）在JavaWeb上读取Properties配置文件
 *         Properties properties = new Properties();
 *         properties.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
 *         String username = properties.getProperty("username");
 *         String password = properties.getProperty("password");
 *
 *     1-3）
 */
public class _3_ServletContext与在JavaWeb读取Properties extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //获取 “application.properties” 文件中数据
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        //存到ServletContext对象中
        ServletContext context = this.getServletContext();
        context.setAttribute("username",username);
        context.setAttribute("password",password);

        //从存到ServletContext对象中获取数据
        out.println("<span>username="+context.getAttribute("username")+", password="+context.getAttribute("password"));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
