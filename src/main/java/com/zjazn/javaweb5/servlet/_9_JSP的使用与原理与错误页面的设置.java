package com.zjazn.javaweb5.servlet;

import javax.servlet.http.HttpServlet;

/**
 *
 * 1、_9_JSP的使用与原理:
 *    当我们初次访问一个jsp时，使将jsp转为HttpServlet的间接子类 XX_jsp.java，
 *           ![](https://cdn.jsdelivr.net/gh/18476305640/typora@master/image/16358369429721635836942882.png)
 *          比如位置转换后存放的位置：C:\Users\21192\AppData\Local\JetBrains\IntelliJIdea2021.2\tomcat\e145fc2a-1456-43ee-888e-eec501550944\work\Catalina\localhost\javaweb5_war\org\apache\jsp
 *          XX_jsp.java解析：
 *              //继承了HttpServlet的子类HttpJspBase
 *              public final class logon_jsp extends org.apache.jasper.runtime.HttpJspBase...
 *
 *              //这是我们可以在jsp中使用request，response的原因
 *              public void _jspService(final javax.servlet.http.HttpServletRequest request,
 *                                      final javax.servlet.http.HttpServletResponse response)
 *
 *              //除此，还定义了常用的方法便于我们在jsp中使用（九大内置对象）
 *              response.setContentType("text/html;charset=UTF-8");
 *              pageContext = _jspxFactory.getPageContext(this, request, response, null, true, 8192, true);
 *              _jspx_page_context = pageContext;
 *              application = pageContext.getServletContext();
 *              config = pageContext.getServletConfig();
 *              session = pageContext.getSession();
 *              out = pageContext.getOut();
 *              _jspx_out = out;
 *
 *
 *              //jsp的各种代码被解析为 _jspService 方法中，当然也可以声明方法 <%!%> ,解析的方法将放在类下。
 *                  <%
 *                      Integer sum = 1+2;
 *                      String color = "red";
 *                  %>
 *                  <h2><%=sum%></h2>
 *                  <h2>${pageContext.request.contextPath}</h2>
 *              //被解析为以下，放在
 *                  Integer sum = 1+2;
 *                  String color = "red";
 *                  out.write("\n");
 *                  out.write("<h2>");
 *                  out.print(sum);
 *                  out.write("</h2>\n");
 *                  out.write("<h2>");
 *                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
 *                  out.write("</h2>\n");
 *      jsp基本语法：
 *          <% %> java代码
 *          <%= %> 输出到页面
 *          ${ }   从pageContext获取输出
 *      除了有jsp的基本语法外，还有jsp的指令，
 *              语法是<%@ %>,比如：
 *                  声明编码信息： <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 *                  声明是一个错误页面：<%@ page isErrorPage="true" %>
 *                  将其它页面包含（common与index.jsp同级）：<%@ include file="/common/header.jsp" %>
 *              ...
 *
 * 2、错误页面的设置
 *      ![](https://cdn.jsdelivr.net/gh/18476305640/typora@master/image/16358418393321635841839269.png)
 *      web.xml中加入，要注意的是/error文件夹与/index.jsp 在同一目标下：
 *      <error-page>
 *          <error-code>404</error-code>
 *          <location>/error/404.jsp</location>
 *      </error-page>
 *      <error-page>
 *          <error-code>500</error-code>
 *          <location>/error/500.jsp</location>
 *      </error-page>
 *
 *
 *
 *
 *
 *
 */
public class _9_JSP的使用与原理与错误页面的设置 extends HttpServlet {
}
