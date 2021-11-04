package com.zjazn.javaweb5.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Cookie ：已封装在common中 CookieUtils
 * Session: 一个浏览器独占一个session，当关闭浏览器时，session被销毁;
 *         可以使用setAttribute ，getAttribute对数据进行存取, 获取数据是一个object需要进行强转，
 *         我们可以设置session的存活时间，及销毁Session
 *         web.xml中配置：
 *         <session-config>
 *              <session-timeout>15</session-timeout>
 *         </session-config>
 *         在java代码使用session对象设置：
 *         session.setMaxInactiveInterval(30*60);
 *
 *
 * 区别： Cookie是保存在浏览器中，保留时间长，而Session是保存在服务器中，保留时间短。
 *
 */
public class _8_Cookie与Session extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("uid","大聪明");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
