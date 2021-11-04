package com.zjazn.javaweb5.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1、过滤器
        需要创建一个类 implements Filter 重写三个方法：
            init：随web容器的启动而初始化监听。
            doFilter： 可以在像在Servlet内操作，所以可以将Servlet内的公共操作提到过滤器中，注意需要写一个固定传递语句：
                    chain.doFilter(request,response); 让进入Servlet中
            destroy：承web容器的关闭而销毁

        然后去web.xml中配置过滤器（什么url要经过这个过滤器）
             <filter>
                 <filter-name>CharacterEncodingFilter</filter-name>
                 <filter-class>com.zjazn.javaweb5.filter.CharacterEncodingFilter</filter-class>
             </filter>
             <filter-mapping>
                 <filter-name>CharacterEncodingFilter</filter-name>
                 <url-pattern>/*</url-pattern>
             </filter-mapping>


 2、监听器
    监听有很多，但在web中作用并不多
    示例：HttpSessionListener
        需要创建一个类来实现 HttpSessionListener， 然后重写 sessionCreated，  sessionDestroyed 方法
        分别对应的session的创建与销毁。
        然后在web.xml中配置listener:
             <listener>
                 <listener-class>com.zjazn.javaweb5.listener.OnLineCountListener</listener-class>
             </listener>

    扩展：session的超时配置
         <session-config>
            <session-timeout>1</session-timeout>
         </session-config>

 * }
 */
public class _12_过滤器与监听器 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg","过滤器Servlet!");
        request.getRequestDispatcher("filter.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
