package com.zjazn.javaweb5.servlet;

/**
 * 九大内置对象:
 *    pageContext       (使普通Java类可访问WEB资源，自定义 标签常用) --域对象
 *    request             HttpServletRequest                  --域对象
 *    session             HttpSession                         --域对象
 * 　　application        ServletcContext                      --域对象
 * 　　response          HttpServletResponse

 * 　　config                ServletConfig
 * 　　exception          (特殊情况下使用)
 * 　　page                 this(本JSP页面)
 * 　　out                   JspWriter（带缓冲的PrintWriter）
 *
 * 四大作用域：
 *    这些域对象就是用来存数据的，只在它们的生命周期不同。
 *    pageContext      --域对象 ：只在当前页面有效
 *    request          --域对象： 在同一请求中（包括转发）有效
 *    session          --域对象： 在一次对话中有效
 * 　　application      --域对象： 在整个web应用中有效
 *
 *    如何获取这些数据？
 *        我们使用EL表达式， ${变量名} 取出，寻找途径是域的从小到大（pageContext~application）
 */
public class _10_九大内置对象四大作用域 {
}
