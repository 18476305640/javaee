package com.zjazn.javaweb5.filter;


import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter 过滤器初始化了~");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入了过滤器，正在进入Servlet~");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request,response);
        System.out.println("经过了Servlet，正在返回在浏览器~");

    }
    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter 过滤器初销毁了~");
    }
}
