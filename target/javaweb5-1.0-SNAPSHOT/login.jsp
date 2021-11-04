<%--
  Created by IntelliJ IDEA.
  User: 21192
  Date: 2021/11/2
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>用户登录</h1>
    <form method="post" action="${pageContext.request.contextPath}/login">
        请输入用户名：<input type="text" name="username"> <br/>
        请输入密码： <input type="password" name="password"> <br />
        <button type="submit">登录</button>
    </form>

</body>
</html>
