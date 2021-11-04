package com.zjazn.javaweb5.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnLineCountListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(se.getSession().getId()+" session创建了~");
        ServletContext servletContext = se.getSession().getServletContext();
        Integer olc = (Integer)servletContext.getAttribute("olc");
        if (olc == null) {
            servletContext.setAttribute("olc",1);
        }else {
            servletContext.setAttribute("olc", ++olc);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(se.getSession().getId()+" session销毁了~");
        ServletContext servletContext = se.getSession().getServletContext();
        Integer olc = (Integer)servletContext.getAttribute("olc");
        servletContext.setAttribute("olc", --olc);
    }
}
